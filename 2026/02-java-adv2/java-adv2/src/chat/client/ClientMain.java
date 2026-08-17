package chat.client;

import java.io.IOException;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 10.
 * @fileName : ClientMain
 */
public class ClientMain {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        Client client = new Client("localhost", PORT);
        client.start();
    }
}
