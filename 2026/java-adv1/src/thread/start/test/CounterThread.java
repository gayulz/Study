package thread.start.test;

/**
 * @author : gayul.kim
 * @date : 2026. 4. 25.
 * @fileName : CounterThread
 */
public class CounterThread extends Thread{
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                thread.util.MyLogger.log("value: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
