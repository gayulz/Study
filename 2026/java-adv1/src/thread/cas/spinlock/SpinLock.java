package thread.cas.spinlock;

import java.util.concurrent.atomic.AtomicBoolean;

import static thread.util.MyLogger.log;

/**
 * @author : gayul.kim
 * @date : 2026. 7. 21.
 * @fileName : SpinLock
 */
public class SpinLock {
    private final AtomicBoolean lock = new AtomicBoolean(false);

    public void lock(){
        log("락 획득 시도");
        while (!lock.compareAndSet(false, true)) {
            // 락을 획득할 때 까지 스핀 대기(바쁜 대기)한다.
            log("락 획득 실패 - 스핀 대기");
        }
        log("락 획득 완료");
    }

    public void unlock(){
        lock.set(false);
        log("락 반납 완료");
    }
}
