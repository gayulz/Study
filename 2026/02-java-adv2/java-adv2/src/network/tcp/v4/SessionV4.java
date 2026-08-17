package network.tcp.v4;

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
public class SessionV4 implements Runnable{
    private final Socket socket;

    public SessionV4(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        DataInputStream input = null;
        DataOutputStream output = null;
        try {
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());


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
        } finally{
            closeAll(socket, input, output);
            log("연결 종료 : " + socket);
        }
    }
}
