package thread.control.interrupt;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

/**
 * @author : gayul.kim
 * @date : 2026. 5. 18.
 * @fileName : ThreadStopMainV1
 */
public class ThreadStopMainV3 {
    public static void main(String[] args) {

        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();
        sleep(100);
        log("작업 중단 지시 thread.intterupt()");
        thread.interrupt();
        log("work 스레드 인터럽트 상태 1 = " + thread.isInterrupted());
    }

    static class MyTask implements Runnable{

        @Override
        public void run() {
            while(!Thread.currentThread().isInterrupted()){
                // 인터럽트 상태는 변경하지않과 check만함
                log("작업 중");
            }
            log("work 스레드 인터럽트 상태 2 = " + Thread.currentThread().isInterrupted());
            log("state = " + Thread.currentThread().getState());

            try{
                log("자원 정리");
                Thread.sleep(1000);
            }catch(InterruptedException e){
                log("자원 정리 실패 - 자원 정리 중 인터럽트 발생");
                log("work 스레드 인터럽트 상태 3 = " + Thread.currentThread().isInterrupted());
            }
            log("자원 종료");
        }
    }
}