package thread.control.test;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

/**
 * @author : gayul.kim
 * @date : 2026. 5. 17.
 * @fileName : JoinTest1Main
 */
public class JoinTest1Main {
    public static void main(String[] args) throws InterruptedException {
        log("------------------------- main 시작");
        Thread t1 = new Thread(new MyTask(), "t1");
        Thread t2 = new Thread(new MyTask(), "t2");
        Thread t3 = new Thread(new MyTask(), "t3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        log("------------------------- main 종료");
    }

    static class MyTask implements Runnable{

        @Override
        public void run() {
            for (int i = 1 ; i <= 3; i++) {
                log(i);
                sleep(1000);
            }
        }
    }
}
