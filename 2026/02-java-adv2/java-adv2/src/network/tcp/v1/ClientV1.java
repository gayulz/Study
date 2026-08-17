package network.tcp.v1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static util.MyLogger.log;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 6.
 * @fileName : ClientV1
 */
public class ClientV1 {
    public static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("클라이언트 시작");
        Socket socket = new Socket("localhost", PORT);
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        log("소켓 연결 : " + socket);

        // 서버에게 문자 보내기
        String toSend = "Hello";
        output.writeUTF(toSend);
        log("Client -> server : " + toSend);

        // 서버로부터 문자 받기
        String received = input.readUTF();
        log("Client <- server : " + received);

        // 자원 정리
        log("연결 종료 : " + socket);
        input.close();
        output.close();
        socket.close();
    }
}
