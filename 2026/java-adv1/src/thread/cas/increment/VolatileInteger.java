package thread.cas.increment;

/**
 * @author : gayul.kim
 * @date : 2026. 7. 21.
 * @fileName : BasicInteger
 */
public class VolatileInteger implements IncrementInteger{

    private int value;

    @Override
    public void increment() {
        value++;
    }

    @Override
    public int get() {
        return value;
    }
}
