package thread.start.test;

import static thread.util.MyLogger.log;

/**
 * @author : gayul.kim
 * @date : 2026. 4. 25.
 * @fileName : StartTest4Main
 */
public class StartTest4Main {
    /**
     * 여러 스레드 사용
     * Thread-A , Thread-B 두 스레드를 생성
     * Thread-A는 1초에 한번씩 "A" 출력
     * Thread-B는 0.5초에 한번씩 "B" 출력
     * 이 프로그램은 강제 종료 할 때 까지 계속 실행된다.
     *
     * @param args
     */
    public static void main(String[] args) {

        Thread threadA = new Thread(new ThreadA(), "Thread-A");
        Thread threadB = new Thread(new ThreadB(), "Thread-B");
        threadA.start();
        threadB.start();

    }

    private static class ThreadA implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    log("A");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private static class ThreadB implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    log("B");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}