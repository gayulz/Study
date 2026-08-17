package chat.server.command;

import chat.server.CommandManager;
import chat.server.Session;
import chat.server.SessionManager;

import java.io.IOException;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 10.
 * @fileName : JoinCommand
 */
public class JoinCommand implements Command {

    private final SessionManager sessionManager;

    public JoinCommand(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String[] args, Session session) {
        String username = args[1];
        session.setUsername(username);
        sessionManager.sendAll(username + "님이 입장하였습니다.");
    }
}
