package controller;

import entity.APIPokemon;
import entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * The type View pokemon.
 */
@WebServlet(
        urlPatterns = {"/viewPokemon"}
)

public class ViewPokemon extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * The Mon.
     */
    APIPokemon mon;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        List<APIPokemon> allPokes = (List<APIPokemon>)session.getAttribute("allPokemon");
        String value = req.getParameter("value");
        for(APIPokemon poke : allPokes) {
            mon = new APIPokemon(
                    poke.getRole(),
                    poke.getPokemon(),
                    poke.getAttack(),
                    poke.getDefense(),
                    poke.getHP(),
                    poke.getSpAttack(),
                    poke.getSpDefense()
            );

            req.setAttribute(mon.getPokemon(), mon);

        }
        req.setAttribute("value", value);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/view-pokemon.jsp");
        dispatcher.forward(req, resp);
    }

}
