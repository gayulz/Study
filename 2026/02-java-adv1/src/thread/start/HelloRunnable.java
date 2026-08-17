package thread.start;

/**
 * @author : gayul.kim
 * @date : 2026. 4. 25.
 * @fileName : HelloRunnable
 */
public class HelloRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": HelloRunnable.run()");
    }
}
