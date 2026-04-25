package thread.start.test;
import static thread.util.MyLogger.log;
/**
 * @author : gayul.kim
 * @date : 2026. 4. 25.
 * @fileName : CounterRunnable
 */
public class CounterRunnableMainV3 {
    /**
     * 다음 요구사항에 맞게 멀티스레드 프로그램을 작성해라.
     * 1. CounterRunnable 이라는 이름의 클래스를 만들자, 이 클래스는 Runnable 인터페이스를 구현해야 한다.
     * 2. CounterRunnable 은 1부터 5까지의 숫자를 1초 간격으로 출력해야 한다, 앞서 우리가 만든 log() 기능을 사용하여 출력해라.
     * 3. main 메서드에서 CounterRunnable 의 인스턴스를 이용하여 Thread를 생성하고 실행해라.
     * 스레드의 이름은 "counter"로 지정한다.
     * 오늘의 김영한 쌤 강의는 너무 지루하긴 한데 커=피를 먹으니 좀 더 집중이 되긴 한다,.
     * 지금 몇시지 ?
     * 아니 지금 몇시인데 벌써 졸릴까
     * 오늘부터 코딩테스트 공부도 해야하고 김영한 쌤 인프런 강의도 봐야하고
     * 할게 너무너무 많다.
     * 거기다가 책도 읽으려면 참 바쁠 것 같다ㅓ.
     *
     * @param args
     */

    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    for (int i = 1; i <= 5; i++) {
                        log("value: " + i);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "counter");
        thread.start();

    }
}
