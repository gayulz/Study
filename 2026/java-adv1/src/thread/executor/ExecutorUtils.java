package thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

import static thread.util.MyLogger.log;

/**
 * @author : gayul.kim
 * @date : 2026. 7. 27.
 * @fileName : ExecutorUtils
 */
public abstract class ExecutorUtils {
    public static void printState(ExecutorService executorService){
        if(executorService instanceof ThreadPoolExecutor poolExecutor){
            int pool = poolExecutor.getPoolSize();
            int active = poolExecutor.getActiveCount();
            int queuedTask = poolExecutor.getQueue().size();
            long completedTask = poolExecutor.getCompletedTaskCount();

            log("[pool: " + pool +
                    ", \tactive: " + active +
                    ", \tqueuedTask: " + queuedTask +
                    ", \tcompleted: " + completedTask + "]");
        } else {
            log(executorService);
        }
    }
}
