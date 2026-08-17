package thread.control.join;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

/**
 * @author : gayul.kim
 * @date : 2026. 5. 17.
 * @fileName : JoinMainV1
 */
public class JoinMainV2 {
    public static void main(String[] args) {
        log("Start");
        SumTask task1 = new SumTask(1, 50);
        SumTask task2 = new SumTask(51, 100);
        Thread thread1 = new Thread(task1, "thread-1");
        Thread thread2 = new Thread(task2, "thread-2");

        thread1.start();
        thread2.start();

        // 정확한 타이밍을 맞추어 기다리기 어려움
        log("main 스레드 sleep()");
        sleep(3000);
        log("main 스레드 sleep 깨어남");

        log("task1.result = " + task1.result);
        log("task2.result = " + task2.result);

        int sumAll = task1.result + task2.result;
        log("task1.result + task2.result = " + sumAll);
        log("End");
    }


    static class SumTask implements Runnable{
        int startValue;
        int endValue;
        int result = 0;
        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            log("작업 시작");
            sleep(2000);
            int sum = 0;
            for (int i = startValue; i <= endValue; i++) {
                sum += i;
            }
            result = sum;
            log("합산 : " + result);
            log("작업 종료");
        }
    }
}
