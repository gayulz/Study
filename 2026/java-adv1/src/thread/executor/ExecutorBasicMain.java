package thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static thread.executor.ExecutorUtils.printState;
import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

/**
 * @author : gayul.kim
 * @date : 2026. 7. 27.
 * @fileName : ExecutorBasicMain
 */
public class ExecutorBasicMain {
    public static void main(String[] args) {

        ExecutorService es = new ThreadPoolExecutor(2, 2, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        log("==\t 초기 상태 \t==");
        printState(es);
        es.execute(new RunnableTask("taskA"));
        es.execute(new RunnableTask("taskB"));
        es.execute(new RunnableTask("taskC"));
        es.execute(new RunnableTask("taskD"));

        log("==\t 작업 수행 중 \t==");
        printState(es);

        sleep(3000);
        log("==\t 작업 수행 완료 \t==");
        printState(es);

        es.close();
        log("==\t Showdown 완료 \t==");
        printState(es);
    }
}
