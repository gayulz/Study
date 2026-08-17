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
public class BoundedQueueV6_3 implements BoundedQueue {

    private BlockingQueue<String> queue;
    public BoundedQueueV6_3(int max) {
        this.queue = new ArrayBlockingQueue<String>(max);
    }

    @Override
    public void put(String data) {
        boolean result = false;
        try {
            result = queue.offer(data, 1, TimeUnit.NANOSECONDS);
            log("저장 시도 결과 = " + result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String take() {
        try {
            return queue.poll(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
