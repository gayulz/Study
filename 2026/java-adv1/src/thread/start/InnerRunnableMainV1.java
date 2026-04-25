package thread.start;

import static thread.util.MyLogger.log;

/**
 * @author : gayul.kim
 * @date : 2026. 4. 25.
 * @fileName : InnerRunnableMainV1
 */
public class InnerRunnableMainV1 {
    public static void main(String[] args) {
        log("main() start");

        /**
         * 중첩 클래스 사용
         */
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();


        log("main() end");
    }

    static class MyRunnable implements Runnable{

        @Override
        public void run() {
//            System.out.println(Thread.currentThread().getName() + ": MyRunnable.run()");
            log("run()");
        }
    }
}
