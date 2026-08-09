package network.tcp.v4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import static network.tcp.SocketCloseUtil.closeAll;
import static util.MyLogger.log;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 6.
 * @fileName : ClientV4
 */
public class ClientV4 {
    public static final int PORT = 12345;

    public static void main(String[] args) {
        log("클라이언트 시작");

        // finally 블록에서 변수를 접근해야 한다, 따라서 try 블록 안에서 선언할 수 없다.
        Socket socket = null;
        DataInputStream input = null;
        DataOutputStream output = null;
        try {
            socket = new Socket("localhost", PORT);
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            log("소켓 연결: " + socket);


            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.print("전송 문자: ");
                String toSend = sc.nextLine(); // 서버에게 문자 보내기
                 output.writeUTF(toSend);
                 log("client -> server: " + toSend);

                if (toSend.equals("exit")) {
                    break;
                }
                // 서버로부터 문자 받기
                String received = input.readUTF();
                log("client <- server: " + received);
            }
        } catch (IOException e) {
            log(e);
        } finally{
            closeAll(socket, input, output);
            log("연결 종료: " + socket);
        }
    }
}
