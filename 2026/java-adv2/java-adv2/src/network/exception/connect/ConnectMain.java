package network.exception.connect;

import java.io.IOException;
import java.net.Socket;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 9.
 * @fileName : ConnectMain
 */
public class ConnectMain {
    public static void main(String[] args) {
        unkownHostEx1();
        unkownHostEx2();
        connectionRefused();
    }

    private static void unkownHostEx1() {
        try {
            /*UnknownHostException : 해당 IP가 없을 때 나옴*/
            Socket socket = new Socket("999.999.999.999", 80);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void unkownHostEx2() {
        try {
            /*UnknownHostException : 해당 도메인이 없을 때 나옴*/
            Socket socket = new Socket("google.gogo", 80);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void connectionRefused() {
        try {
            /* ConnectionException Connection refused : 미 사용 포트 , 연결이 거절 되는 에러 */
            Socket socket = new Socket("localhost", 45678);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
