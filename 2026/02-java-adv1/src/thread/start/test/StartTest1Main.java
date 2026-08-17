package thread.start.test;

import static thread.util.MyLogger.log;

/**
 * @author : gayul.kim
 * @date : 2026. 4. 25.
 * @fileName : StartTest1Main
 */
public class StartTest1Main {
    public static void main(String[] args) {
        /**
         * Thread 상속
         * 다음 요구 사항에 맞게 멀티스레드 프로그램을 작성해라.
         *
         * 1. Thread 클래스를 상속받은 CounterThread 라는 스레드 클래스를 만들자.
         * 2. 이 스레드는 1부터 5까지의 숫자를 1초 간격으로 출력해야 한다. 앞서 만든 log() 기능을 사용해서 출력해라.
         * 3. main() 메서드에서 CounterThread 스레드 클래스를 만들고 실행해라.
         * 4. 실행 결과를 참조하자.
         */

        CounterThread counter = new CounterThread();
        counter.start();
    }
}
