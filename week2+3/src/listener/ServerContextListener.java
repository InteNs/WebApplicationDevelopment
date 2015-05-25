package listener;

import com.sun.xml.internal.ws.api.policy.PolicyResolver;
import model.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.*;

public class ServerContextListener implements ServletContextListener {
    private String file;
    private ServletContext servletContext;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        // Set servlet context
        servletContext = servletContextEvent.getServletContext();

        // Get real path
        file = servletContext.getRealPath("/")+"users.obj";

        // Create file
        new File(file);

        // Read object file
        try {
            ObjectInputStream reader = new ObjectInputStream(new FileInputStream(file));
            servletContext.setAttribute("usersList", reader.read());
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        try {
            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file));
            writer.writeObject(servletContext.getAttribute("usersList"));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
