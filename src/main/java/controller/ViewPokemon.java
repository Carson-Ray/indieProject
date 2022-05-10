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

@WebServlet(
        urlPatterns = {"/viewPokemon"}
)

public class ViewPokemon extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        List<APIPokemon> allPokes = (List<APIPokemon>) req.getSession().getAttribute("allPokemon");
        String value = req.getParameter("value");
        APIPokemon current = new APIPokemon();
        for(APIPokemon poke : allPokes) {
            if(poke.getPokemon() == value) {
                current = poke;
            }
        }
        req.setAttribute("current", current);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/view-pokemon.jsp");
        dispatcher.forward(req, resp);
    }

}
