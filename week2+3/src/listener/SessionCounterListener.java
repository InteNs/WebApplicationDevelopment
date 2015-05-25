package listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionCounterListener implements HttpSessionListener {

    private static int totalActiveSessions;

    public static int getTotalActiveSession(){
        return totalActiveSessions;
    }

    @Override
    public void sessionCreated(HttpSessionEvent arg0) {
        // +1 to active userSessions
        totalActiveSessions++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent arg0) {
        // -1 from active userSessions
        totalActiveSessions--;
    }
}