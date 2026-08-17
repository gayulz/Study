package thread.bounded;

/**
 * @author : gayul.kim
 * @date : 2026. 6. 18.
 * @fileName : BoundedQueue
 */
public interface BoundedQueue {

    /** 데이터를 보관*/
    String take();

    /** 데이터를 가져감*/
    void put(String data);
}
