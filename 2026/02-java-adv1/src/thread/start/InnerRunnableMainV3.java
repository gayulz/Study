package thread.start;

import static thread.util.MyLogger.log;

/**
 * @author : gayul.kim
 * @date : 2026. 4. 25.
 * @fileName : InnerRunnableMainV1
 */
public class InnerRunnableMainV3 {
    public static void main(String[] args) {
        log("main() start");

        /**
         * 익명 클래스 사용
         */

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                log("run()");
            }

        });
        thread.start();


        log("main() end");
    }
}
