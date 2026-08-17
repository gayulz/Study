package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 9.
 * @fileName : ChatSesstionManager
 */
public class ChatSessionManager {
    private List<ChatSession> chatSessions = new ArrayList<>();

    public synchronized void add(ChatSession chatSession) {
        chatSessions.add(chatSession);
    }

    public synchronized void remove(ChatSession chatSession) {
        chatSessions.remove(chatSession);
    }

    public synchronized void closeAll(){
        for (ChatSession chatSession : chatSessions) {
            chatSession.close();
        }
        chatSessions.clear();
    }

    public String selectUsers() {
        String toSend = "";
        for (int i = 0; i < chatSessions.size(); i++) {
//            if (chatSessions[0].name == null) {
//                toSend += "현재 등록된 사용자가 없습니다";
//            }
            toSend += "[" + (i + 1) + "] " + chatSessions.get(i).getName() + "\n";
        }
        return toSend;
    }
}
