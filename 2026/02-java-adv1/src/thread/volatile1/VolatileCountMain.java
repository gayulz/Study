package thread.volatile1;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

/**
 * @author : gayul.kim
 * @date : 2026. 5. 20.
 * @fileName : VolatileCountMain
 */
public class VolatileCountMain {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread t = new Thread(task, "work");
        t.start();

        sleep(1000);

        task.flag = false;
        log("flag = " + task.flag + ", count = " + task.count + " in main");
    }


    static class MyTask implements Runnable{

        volatile boolean flag = true;
        volatile long count;

        @Override
        public void run() {
            while(flag){
                count++;
                // 1억번에 한번씩 출력
                if(count % 100_000_000 == 0){
                    log("flag = " + flag + ", count = " + count + " in while()");
                }
            }

            log("flag = " + flag + ", count = " + count + " out 종료 ");
        }
    }
}
