package network.exception.connect;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 9.
 * @fileName : SoTimeoutClient
 */
public class SoTimeoutClient {
    public static void main(String[] args) {
        /* 외부 서버와 통신을 하는 경우 반드시 연결 타임아웃과 소켓 타임아웃을 지정해야한다. */
        Socket socket = null;
        try {
            socket = new Socket("localhost", 12345);
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream input = null;
        try {
            input = socket.getInputStream();
            socket.setSoTimeout(3000);
            int read = input.read();
            System.out.println("read = " + read);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
