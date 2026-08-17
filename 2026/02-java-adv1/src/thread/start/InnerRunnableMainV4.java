package thread.start;

import static thread.util.MyLogger.log;

/**
 * @author : gayul.kim
 * @date : 2026. 4. 25.
 * @fileName : InnerRunnableMainV1
 */
public class InnerRunnableMainV4 {
    public static void main(String[] args) {
        log("main() start");

        /**
         * 람다 사용
         */

        Thread thread = new Thread(() -> log("run()"));
        thread.start();


        log("main() end");
    }
}
