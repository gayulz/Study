package thread.volatile1;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

/**
 * @author : gayul.kim
 * @date : 2026. 5. 20.
 * @fileName : VolatileFlagMain
 */
public class VolatileFlagMain {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread t = new Thread(task, "work");
        log("runFlag = " + task.runFlag);
        t.start();


        sleep(1000);
        log("runFlag를 false로 변경 시도");
        task.runFlag = false;
        log("runFlag = " + task.runFlag);
        log("main 종료");
    }

    static class MyTask implements Runnable{

//        boolean runFlag = true;
//         "volatile" 키워드가 핵심 : 캐시 메모리에 있는 걸 무시하고 메인 메모리에 있는 것을 읽어옴
        volatile boolean runFlag = true;

        @Override
        public void run() {
            log("task 시작");
            while(runFlag){
                // runFlag가 false로 변하면 탈출
            }
            log("task 종료");
        }
    }
}
