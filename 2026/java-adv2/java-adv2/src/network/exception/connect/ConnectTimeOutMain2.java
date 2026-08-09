package network.exception.connect;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 9.
 * @fileName : ConnectTimeOutMain
 */
public class ConnectTimeOutMain2 {
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
            Socket socket = new Socket();
            socket.connect(new java.net.InetSocketAddress("192.168.1.250", 45678), 1000);
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
        } catch (ConnectException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        long end= System.currentTimeMillis();
        System.out.println("소요 시간 = " + (end - start) + " ms");
    }
}
