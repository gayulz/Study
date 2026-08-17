package chat.server.command;

import chat.server.Session;

import java.io.IOException;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 10.
 * @fileName : Command
 */
public interface Command {
    void execute(String[] args, Session session) throws IOException;
}
