package thread.executor;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

/**
 * @author : gayul.kim
 * @date : 2026. 7. 27.
 * @fileName : RunnableTask
 */
public class RunnableTask implements Runnable{

    private final String name;
    private int sleepMs = 1000;

    public RunnableTask(String name) {
        this.name = name;
    }

    public RunnableTask(String name, int sllepMs) {
        this.name = name;
        this.sleepMs = sllepMs;
    }

    @Override
    public void run() {
        log(name + "시작");
        sleep(sleepMs);
        log(name + "완료");
    }
}
