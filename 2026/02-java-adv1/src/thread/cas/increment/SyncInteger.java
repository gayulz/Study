package thread.cas.increment;

/**
 * @author : gayul.kim
 * @date : 2026. 7. 21.
 * @fileName : BasicInteger
 */
public class SyncInteger implements IncrementInteger{

    private int value;

    @Override
    public synchronized void increment() {
        value++;
    }

    @Override
    public synchronized int get() {
        return value;
    }
}
