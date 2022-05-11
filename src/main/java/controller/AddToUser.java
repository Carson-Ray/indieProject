package controller;

import entity.User;
import entity.UserPokemon;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(
        urlPatterns = {"/addToUser"}
)

public class AddToUser extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDao<User> dao = new GenericDao<>(User.class);
    GenericDao<UserPokemon> pokeDao = new GenericDao<>(UserPokemon.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("user");
        List<UserPokemon> userPokes = (List<UserPokemon>) req.getSession().getAttribute("userPokemon");
        logger.info("user " + user);

        UserPokemon newPokemon = new UserPokemon(req.getParameter("pok"), req.getParameter("rol"), user);

        pokeDao.saveOrUpdate(newPokemon);

        userPokes.add(newPokemon);
        req.getSession().setAttribute("userPokemon", userPokes);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/profile.jsp");
        dispatcher.forward(req, resp);
    }

}