package thread.cas.increment;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : gayul.kim
 * @date : 2026. 7. 21.
 * @fileName : AtomicInteger
 */
public class MyAtomicInteger implements IncrementInteger{

    AtomicInteger atomicInteger = new AtomicInteger();
    @Override
    public void increment() {
        atomicInteger.incrementAndGet();
    }

    @Override
    public int get() {
        return atomicInteger.get();
    }
}
