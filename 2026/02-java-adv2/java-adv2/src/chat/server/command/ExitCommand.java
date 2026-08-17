package chat.server.command;

import chat.server.Session;
import chat.server.SessionManager;

import java.io.IOException;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 10.
 * @fileName : ExitCommand
 */
public class ExitCommand implements Command{

    @Override
    public void execute(String[] args, Session session) throws IOException {
        throw new IOException("exit");
    }
}
