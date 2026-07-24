package thread.collection.simple.list;

/**
 * @author : gayul.kim
 * @date : 2026. 7. 22.
 * @fileName : SyncProxyList
 */
public class SyncProxyList implements SimpleList {

    private SimpleList target;

    public SyncProxyList(SimpleList target) {
        this.target = target;
    }

    @Override
    public synchronized int size() {
        return target.size();
    }

    @Override
    // 1. lock 획득
    public synchronized void add(Object o) {
        // 2. 원본 메서드 호출
        target.add(o);
        // 3. 원본 메서드 반납.
        // 4. 략 반납
    }

    @Override
    public synchronized Object get(int index) {
        return target.get(index);
    }


    @Override
    public String toString() {
        return target.toString() + " \t\t by " + this.getClass().getSimpleName();
    }
}

