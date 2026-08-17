package thread.start;

/**
 * @author : gayul.kim
 * @date : 2026. 4. 25.
 * @fileName : HelloRunnableMain
 */
public class HelloRunnableMain {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " : man() start");

        HelloRunnable runnable = new HelloRunnable();
        Thread thread = new Thread(runnable);
        thread.start();

        System.out.println(Thread.currentThread().getName() + " : man() end");

    }
}
