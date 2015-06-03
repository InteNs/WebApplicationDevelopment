package listener;

import domain.service.ServiceProvider;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.*;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerContextListener implements ServletContextListener {
    private final Logger logger = Logger.getLogger("listener.SessionCounterListener");

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("blogposts", ServiceProvider.getBlogPostService().getAllBlogPosts());
        try{
            FileHandler fileHandler = new FileHandler(servletContext.getRealPath("/")+"blogLog.xml", true);
            logger.addHandler(fileHandler);
        } catch (IOException ioe) { ioe.printStackTrace(); }
        logger.setLevel(Level.ALL);
        logger.info("Logger initialized");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        for(Handler handler : logger.getHandlers()){
            handler.close();
        }
    }
}
