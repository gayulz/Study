package thread.bounded;

import static thread.util.MyLogger.log;

/**
 * @author : gayul.kim
 * @date : 2026. 6. 19.
 * @fileName : ProducerTask
 */
public class ProducerTask implements Runnable{

    private BoundedQueue queue;
    private String request;
    public ProducerTask(BoundedQueue queue, String request) {
        this.queue = queue;
        this.request = request;
    }



    @Override
    public void run() {
        log("[생산 시도] " + request + " -> " + queue);
        queue.put(request);
        log("[생산 시도] " + request + " -> " + queue);
    }
}
