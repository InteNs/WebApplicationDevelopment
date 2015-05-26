package listener;

import model.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerContextListener implements ServletContextListener {
    private String file, errorLogFile;
    private ServletContext servletContext;
    private Logger logger = Logger.getLogger("listener.SessionCounterListener");

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
            servletContext.setAttribute("usersList", (ArrayList<User>)reader.readObject());
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Initialize logger
        try{
            FileHandler fh = new FileHandler(servletContext.getRealPath("/")+"blogLog.xml", true);
            logger.addHandler(fh);
        } catch (IOException ioe) { ioe.printStackTrace(); }
        logger.setLevel(Level.ALL);
        logger.info("Logger initialized");

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

        // Destroy logger
        for(Handler handler : logger.getHandlers()){
            handler.close();
        }
    }
}
