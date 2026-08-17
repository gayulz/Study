package chat.server;

import java.io.IOException;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 10.
 * @fileName : CommandManager
 */
public interface CommandManager {
    // 클라이언트에게 전달받은 메세지를 처리하는 인터페이스
    // totalMessage : 클라이언트에게 전달 받은 메세지
    // session : 현재 세션
    public void execute(String totalMessage, Session session) throws IOException;
}
