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
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebListener
public class ApplicationStartup implements HttpSessionListener {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        GetPokemon api = new GetPokemon();
        List<APIPokemon> allPokemon = api.requestAPI();
        session.setAttribute("allPokemon", allPokemon);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
