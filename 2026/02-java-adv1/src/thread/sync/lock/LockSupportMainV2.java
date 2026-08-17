package thread.sync.lock;

import java.util.concurrent.locks.LockSupport;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

/**
 * @author : gayul.kim
 * @date : 2026. 6. 7.
 * @fileName : LockSupportMainV1
 */
public class LockSupportMainV2 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new ParkTest(), "Thread-1");
        thread1.start();

        // 잠시 대기 - Thread-1이 park 상태에 빠질 시간 제공을 위한 sleep
        sleep(100);
        log("Thread-1 state: " + thread1.getState());
    }


    static class ParkTest implements Runnable {
        @Override
        public void run() {
            log("park 시작");
            // parNanos : 시간을 지정하여 스레드가 깨어남 , 1초 = 1_000_000_000

            LockSupport.parkNanos(2_000_000_000); // 2초 뒤에 일어나는 것임
            log("park 종료 , state: " + Thread.currentThread().getState());
            log("인터럽트 상태 : " + Thread.currentThread().getName());
        }
    }
}
