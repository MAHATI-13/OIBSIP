
public class TimerThread extends Thread {
    private int time;
    private boolean timeUp = false;

    public TimerThread(int seconds) {
        this.time = seconds;
    }

    public void run() {
        try {
            Thread.sleep(time * 1000);
            timeUp = true;
            System.out.println("\nTime's up! Auto-submitting your test...");
        } catch (InterruptedException e) {
            // User finished before time up
        }
    }

    public boolean isTimeUp() {
        return timeUp;
    }
}
