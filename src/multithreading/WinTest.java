package multithreading;

public class WinTest {
    public static void main(String[] args) {
        Win win = new Win();

        WinThread t1 = new WinThread(win);
        WinThread t2 = new WinThread(win);

        t1.setName("窗口一");
        t2.setName("窗口二");

        t1.start();
        t2.start();
    }
}

class WinThread extends Thread {
    private final Win win;

    public WinThread(Win win) {
        this.win = win;
    }

    @Override
    public void run() {
        while (true) {
            if (win.getTicketNum() > 0) {
                win.sellATicket();
            } else {
                break;
            }
        }
    }
}
