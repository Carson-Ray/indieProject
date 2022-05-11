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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        urlPatterns = {"/viewProfile"}
)

public class ViewProfile extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDao<User> userDao = new GenericDao<>(User.class);
    GenericDao<UserPokemon> pokeDao = new GenericDao<>(UserPokemon.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<User> users = userDao.getAll();
        req.setAttribute("users", users);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/profile.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/profile.jsp");
        dispatcher.forward(req, resp);
    }

}
