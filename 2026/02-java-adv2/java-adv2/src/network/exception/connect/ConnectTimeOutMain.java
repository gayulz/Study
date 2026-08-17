package network.exception.connect;

import java.io.IOException;
import java.net.Socket;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 9.
 * @fileName : ConnectTimeOutMain
 */
public class ConnectTimeOutMain {
    public static void main(String[] args) {
        /*
        * OS 기본 대기 시간
        * Windows : 약 21초
        * Linux : 약 75 ~ 180초 사이
        * Mac : 대략 75초
        * 에러 메세지 : java.net.ConnectException: Operation timed out
        * */
        long start = System.currentTimeMillis();

        try {
            Socket socket = new Socket("192.168.1.250", 45678);
        } catch (IOException e) {
            e.printStackTrace();
        }

        long end= System.currentTimeMillis();
        System.out.println("소요 시간 = " + (end - start) + " ms");
    }
}
