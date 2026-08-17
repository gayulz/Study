package thread.start.test;

import static thread.util.MyLogger.log;

/**
 * @author : gayul.kim
 * @date : 2026. 4. 25.
 * @fileName : StartTest4Main
 */
public class StartTest4MainV1 {
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
        Thread threadA = new Thread(new PrintWork("A", 1000), "Thead-A");
        Thread threadB = new Thread(new PrintWork("B", 500), "Thread-B");

        threadA.start();
        threadB.start();
    }

    private static class PrintWork implements Runnable {
        private String content;
        private int sleepMs;

        public PrintWork(String content, int sleepMs) {
            this.content = content;
            this.sleepMs = sleepMs;
        }

        @Override
        public void run(){
            while(true){
                log(content);
                try{
                    Thread.sleep(sleepMs);
                } catch(InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
        }
    }
}