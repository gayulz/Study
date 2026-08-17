package chat.server.command;

import chat.server.Session;
import chat.server.SessionManager;

import java.io.IOException;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 10.
 * @fileName : ChangeCommand
 */
public class ChangeCommand implements Command{
    private final SessionManager sessionManager;

    public ChangeCommand(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String[] args, Session session) throws IOException {
        String username = args[1];
        sessionManager.sendAll(session.getUsername() + "님이 " + username + "로 이름을 변경했습니다.");
        session.setUsername(username);

    }
}
