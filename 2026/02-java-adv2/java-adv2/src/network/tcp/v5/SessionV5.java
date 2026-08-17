package network.tcp.v5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static network.tcp.SocketCloseUtil.closeAll;
import static util.MyLogger.log;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 6.
 * @fileName : SessionV3
 */
public class SessionV5 implements Runnable {
    private final Socket socket;

    public SessionV5(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (socket;
             DataInputStream input = new DataInputStream(socket.getInputStream());
             DataOutputStream output = new DataOutputStream(socket.getOutputStream());) {
            while (true) {
                // 클라이언트으로 부터 문자 받기
                String received = input.readUTF();
                log("Client -> server : " + received);

                if (received.equals("exit")) {
                    break;
                }
                // 클라이언트에게 문자 보내기
                String toSend = received + " World!";
                output.writeUTF(toSend);
                log("Client <- server : " + toSend);
            }
        } catch (IOException e) {
            log(e);
        }
    }
}
