package controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import entity.*;
import services.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.List;

/**
 * The type Application startup.
 */
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
    public void sessionDestroyed(HttpSessionEvent se) {}
}
