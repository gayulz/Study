package thread.sync.lock;

import java.util.concurrent.locks.LockSupport;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

/**
 * @author : gayul.kim
 * @date : 2026. 6. 7.
 * @fileName : LockSupportMainV1
 */
public class LockSupportMainV1 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new ParkTest(), "Thread-1");
        thread1.start();

        sleep(100);
        log("Thread-1 state: " + thread1.getState());

        log("main -> unpark(Thread-1)");

        LockSupport.unpark(thread1); // 1. unpark 사용
    }


    static class ParkTest implements Runnable {
        @Override
        public void run() {
            log("park 시작");
            LockSupport.park();
            log("park 종료 , state: " + Thread.currentThread().getState());
            log("인터럽트 상태 : " + Thread.currentThread().getName());
        }
    }
}
