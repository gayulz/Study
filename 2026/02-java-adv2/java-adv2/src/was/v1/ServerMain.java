package was.v1;

import java.io.IOException;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 12.
 * @fileName : ServerMain
 */
public class ServerMain {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        HttpServerV1 server = new HttpServerV1(PORT);
        server.start();
    }
}
