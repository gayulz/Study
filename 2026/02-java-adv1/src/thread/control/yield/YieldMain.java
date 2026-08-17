package thread.control.yield;


import static thread.util.ThreadUtils.sleep;

/**
 * @author : gayul.kim
 * @date : 2026. 5. 19.
 * @fileName : YieldMain
 */
public class YieldMain {
    static final int THREAD_COUNT = 1000;

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(new MyRunnable());
            thread.start();
        }
    }

    static class MyRunnable implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                // 1. empty
                System.out.println(Thread.currentThread().getName() + " : " + i);

                // 2. sleep(1);
                sleep(1);
                // 3. Thread.yield();
                Thread.yield();
            }
        }
    }
}
