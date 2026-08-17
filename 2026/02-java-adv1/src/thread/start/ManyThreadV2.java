package thread.start;

import static thread.util.MyLogger.log;

/**
 * @author : gayul.kim
 * @date : 2026. 4. 25.
 * @fileName : ManyThreadV1
 */
public class ManyThreadV2 {
    public static void main(String[] args) {
        log("main() start");

        HelloRunnable runnable = new HelloRunnable();

        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }

        // Thread 실행 및 순서는 언제 어떻게 어떤 순서로 될지 모른다 .
        // 운영 체제의 마음임 !

        log("main() end");
    }
}
