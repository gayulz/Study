package chat.server.command;

import chat.server.Session;
import chat.server.SessionManager;

import java.io.IOException;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 10.
 * @fileName : MessageCommand
 */
public class MessageCommand implements Command{

    private final SessionManager sessionManager;
    public MessageCommand(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String[] args, Session session) throws IOException {
        String message = args[1];
        sessionManager.sendAll("[" + session.getUsername() + "] " + message);
    }
}
