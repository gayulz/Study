package network.exception.close.reset;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

import static util.MyLogger.log;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 9.
 * @fileName : ResetCloseClient
 */
public class ResetCloseClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost", 12345);
        log("소켓 연결 : " + socket);
        InputStream input = socket.getInputStream();
        OutputStream output = socket.getOutputStream();

        //  client <- server : FIN
        Thread.sleep(1000);

        // client -> server : PUSH[1]
        output.write(1);

        // client <- server : RST
        Thread.sleep(1000); // RST 메세지 전송 대기

        try {
            int read = input.read();
            System.out.println("read : " + read);
        } catch (SocketException e){
            /*
            * java.net.SocketException: Connection reset
            * */
            e.printStackTrace();
        }

        try {
            output.write(1);
        } catch (SocketException e){
            /*
            * java.net.SocketException: Broken pipe
            * */
            e.printStackTrace();
        }

        socket.close();
        log("소켓 종료");
    }
}
