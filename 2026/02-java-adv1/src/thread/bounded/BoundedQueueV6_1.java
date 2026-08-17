package thread.bounded;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author : gayul.kim
 * @date : 2026. 7. 18.
 * @fileName : BoundedQueueV6_1
 */
public class BoundedQueueV6_1 implements BoundedQueue {

    private BlockingQueue<String> queue;
    public BoundedQueueV6_1(int max) {
        this.queue = new ArrayBlockingQueue<String>(max);
    }

    @Override
    public void put(String data) {
        try {
            queue.put(data);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String take() {
        try {
            return queue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
