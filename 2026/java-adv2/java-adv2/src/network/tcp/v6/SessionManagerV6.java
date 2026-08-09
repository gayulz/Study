package network.tcp.v6;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 6.
 * @fileName : SessionManagerV6
 */
// 동시성 처리가 필요함
public class SessionManagerV6 {

    private List<SessionV6> sessions = new ArrayList<>();

    public synchronized void add(SessionV6 session) {
        sessions.add(session);
    }

    public synchronized void remove(SessionV6 session) {
        sessions.remove(session);
    }

    public synchronized void closeAll() {
        for (SessionV6 session : sessions) {
           session.close();
        }
        sessions.clear();
    }
}
