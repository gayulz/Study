package thread.bounded;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import static thread.util.MyLogger.log;

/**
 * @author : gayul.kim
 * @date : 2026. 7. 18.
 * @fileName : BoundedQueueV6_1
 */
public class BoundedQueueV6_4 implements BoundedQueue {

    private BlockingQueue<String> queue;
    public BoundedQueueV6_4(int max) {
        this.queue = new ArrayBlockingQueue<String>(max);
    }

    @Override
    public void put(String data) {
        queue.add(data);
        // IllegalStateException : Queue Full
    }

    @Override
    public String take() {
        return queue.remove();
        // NoSuchElementException : Queue Empty
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
