package listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.logging.Logger;

public class SessionCounterListener implements HttpSessionListener {

    private int totalActiveSessions = 0;

    public void sessionCreated(HttpSessionEvent arg0) {
        Logger.getLogger("listener.SessionCountListener").info("Session created, total active sessions: "+ totalActiveSessions);
        totalActiveSessions++;
    }

    public void sessionDestroyed(HttpSessionEvent arg0) {
        Logger.getLogger("listener.SessionCountListener").info("Session destroyed, total active sessions: "+ totalActiveSessions);
        totalActiveSessions--;
    }
}