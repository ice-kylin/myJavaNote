package objectoriented.exer.equals;

public class Order {
    private int orderId;
    private String orderName;

    public Order() {
    }

    public Order(int orderId, String orderName) {
        this.orderId = orderId;
        this.orderName = orderName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public boolean equals(Object o) {
        if (o instanceof Order) {
            if (o == this) {
                return true;
            } else {
                Order cO = (Order) o;
                return cO.getOrderId() == getOrderId() && cO.getOrderName().equals(getOrderName());
            }
        } else {
            return false;
        }
    }
}
