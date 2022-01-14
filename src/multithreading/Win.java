package multithreading;

public class Win {
    private int ticketNum;

    public Win() {
        ticketNum = 100;
    }

    public Win(int ticketNum) {
        this.ticketNum = ticketNum;
    }

    public int getTicketNum() {
        return ticketNum;
    }

    public void sellATicket() {
        if (ticketNum > 0) {
            System.out.println(Thread.currentThread().getName() + "：卖了一张票（" + ticketNum-- + "）");
        } else {
            throw new RuntimeException(Thread.currentThread().getName() + "：票已经卖完了");
        }
    }
}
