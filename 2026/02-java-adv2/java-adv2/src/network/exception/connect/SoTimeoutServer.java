package network.exception.connect;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 9.
 * @fileName : SoTimeoutServer
 */
public class SoTimeoutServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(12345);
        serverSocket.accept();

        Thread.sleep(100_000);
    }
}
