package thread.control.interrupt;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

/**
 * @author : gayul.kim
 * @date : 2026. 5. 18.
 * @fileName : ThreadStopMainV1
 */
public class ThreadStopMainV1 {
    public static void main(String[] args) {

        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();
        sleep(4000);
        log("작업 중단 지시 runFlag = false");
        task.runFlag = false;
    }

    static class MyTask implements Runnable{

        volatile boolean runFlag = true;

        @Override
        public void run() {
            while(runFlag){
                log("작업 중");
                sleep(3000);
            }
            log("자원 정리");
            log("자원 종료");
        }
    }
}