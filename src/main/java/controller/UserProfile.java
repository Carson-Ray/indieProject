package controller;

import entity.User;
import entity.UserPokemon;
import persistence.ConnectRDS;
import persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        urlPatterns = {"/profile"}
)

public class UserProfile extends HttpServlet {

    private Connection connection;
    private ConnectRDS rds;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        rds = ConnectRDS.getInstance();
        rds.getRemoteConnection();

        GenericDao userDao = new GenericDao(User.class);
        GenericDao pokeDao = new GenericDao(UserPokemon.class);

        List<User> users = userDao.getAll();

        User user = (User)req.getAttribute("user");

        for (User wilson : users) {
            if (user.equals(wilson)) {
                break;
            } else {
                userDao.insert(user);
            }
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/profile.jsp");
        dispatcher.forward(req, resp);
    }
}
