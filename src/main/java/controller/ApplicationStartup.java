package controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import entity.*;
import controller.*;
import services.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name= "ApplicationStartup", urlPatterns = {"/application-startup"}, loadOnStartup = 1)

public class ApplicationStartup implements ServletContextListener {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            ServletContext context = sce.getServletContext();
            GetPokemon api = new GetPokemon();
            List<APIPokemon> allPokemon = api.requestAPI();
            context.setAttribute("allPokemon", allPokemon);
        } catch (Exception e) {
            logger.error(e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
