package multithreading;

/*
# 线程通信的应用：生产者 / 消费者问题

- 生产者（Producer）将产品交给店员（Clerk），而消费者（Customer）从店员处取走产品
- 店员一次只能持有固定数量的产品（比如 20）
- 如果生产者试图生产更多的产品，店员会叫生产者停一下
  - 如果店中有空位放产品了再通知生产者继续生产
- 如果店中没有产品了，店员会告诉消费者等一下
  - 如果店中有产品了再通知消费者来取走商品

## 分析

1. 是否是多线程的问题
  - 是（生产者线程、消费者线程）
2. 是否有共享数据
  - 是（店员或产品）
3. 如何解决线程安全问题
  - 同步机制
4. 是否涉及线程的通信
  - 是
 */
public class ProducerConsumerTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer p1 = new Producer(clerk, null);
        Customer c1 = new Customer(clerk, null);

        p1.setCustomer(c1);
        c1.setProducer(p1);

        p1.setName("生产者一号");
        c1.setName("消费者一号");

        p1.start();
        c1.start();
    }
}

class Clerk {
    private static final int MAX_PRODUCT_NUM = 20;
    private static final int MIN_PRODUCT_NUM = 0;

    private int productNum;

    public synchronized void listProduct() throws InterruptedException {
        if (productNum < MAX_PRODUCT_NUM) {
            Thread.sleep(100);

            System.out.println(Thread.currentThread().getName() + "：已生产并上架第 " + ++productNum + " 个商品");
            notify();
        } else {
            wait();
        }
    }

    public synchronized void soldProduct() throws InterruptedException {
        if (productNum > MIN_PRODUCT_NUM) {
            Thread.sleep(100);

            System.out.println(Thread.currentThread().getName() + "：已售出第 " + productNum-- + " 个商品");
            notify();
        } else {
            wait();
        }
    }
}

class Producer extends Thread {
    private final Clerk clerk;
    private Customer customer;

    public Producer(Clerk clerk, Customer customer) {
        this.clerk = clerk;
        this.customer = customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void produceProduct() throws InterruptedException {
        clerk.listProduct();
    }

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (customer.isAlive()) {
                try {
                    produceProduct();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Customer extends Thread {
    private final Clerk clerk;
    private Producer producer;

    public Customer(Clerk clerk, Producer producer) {
        this.clerk = clerk;
        this.producer = producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public void consumerProduct() throws InterruptedException {
        clerk.soldProduct();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (producer.isAlive()) {
                try {
                    consumerProduct();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
