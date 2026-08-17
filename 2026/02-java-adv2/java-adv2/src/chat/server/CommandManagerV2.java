package chat.server;

import java.io.IOException;
import java.util.List;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 10.
 * @fileName : CommandManagerV1
 */
public class CommandManagerV2 implements CommandManager{
    private final SessionManager sessionManager;
    private final String DELIMITER = "\\|";

    public CommandManagerV2(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String totalMessage, Session session) throws IOException {

        // /join|{name}
        if (totalMessage.startsWith("/join")) {
            String[] split = totalMessage.split(DELIMITER);
            String username = split[1];
            session.setUsername(username);
            sessionManager.sendAll(username + "님이 입장하였습니다.");
        } else if (totalMessage.startsWith("/message")) {
            String[] split = totalMessage.split(DELIMITER);
            String message = split[1];
            sessionManager.sendAll("[" + session.getUsername() + "] " + message);
        } else if (totalMessage.startsWith("/change")) {
            String[] split = totalMessage.split(DELIMITER);
            String username = split[1];
            sessionManager.sendAll(session.getUsername() + "님이 " + username + "로 이름을 변경했습니다.");
            session.setUsername(username);
        } else if (totalMessage.startsWith("/users")) {
            List<String> usernames = sessionManager.getAllUsername();
            StringBuilder sb = new StringBuilder();
            sb.append("전체 접속자 : ").append(usernames.size()).append("\n");
            for(String username : usernames){
                sb.append(" - ").append(username).append("\n");
            }
            session.send(sb.toString());
        } else if (totalMessage.startsWith("/exit")) {
            throw new IOException("exit");
        } else {
            session.send("처리할 수 없는 명령어 입니다: " + totalMessage);
        }
    }
}
