package thread.start;

import static thread.util.MyLogger.log;

/**
 * @author : gayul.kim
 * @date : 2026. 4. 25.
 * @fileName : InnerRunnableMainV1
 */
public class InnerRunnableMainV2 {
    public static void main(String[] args) {
        log("main() start");

        /**
         * 익명 클래스 사용
         */
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                log("run()");
            }

        };
        Thread thread = new Thread(runnable);
        thread.start();


        log("main() end");
    }
}
