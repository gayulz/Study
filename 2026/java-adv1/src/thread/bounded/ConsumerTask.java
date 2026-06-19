package thread.bounded;

import static thread.util.MyLogger.log;

/**
 * @author : gayul.kim
 * @date : 2026. 6. 19.
 * @fileName : ConsumerTask
 */
public class ConsumerTask implements Runnable{
    private BoundedQueue queue;

    public ConsumerTask(BoundedQueue queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        log("[소비 시도]     ? <- " + queue);
        String data = queue.take();
        log("[소비 완료] " + data + " <- " + queue);

    }
}
