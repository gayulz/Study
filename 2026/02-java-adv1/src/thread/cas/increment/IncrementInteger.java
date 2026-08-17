package thread.cas.increment;

/**
 * @author : gayul.kim
 * @date : 2026. 7. 21.
 * @fileName : IncrementInteger
 * IncrementIngeger : 값을 증가하는 기능을 가진 숫자 기능을 제공하는 인터페이스
 */
public interface IncrementInteger {
    // 값을 하나 증가
    void increment();

    // 값을 조회
    int get();
}
