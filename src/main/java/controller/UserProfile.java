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

        if (req.getAttribute("user") != null) {
            req.setAttribute("userForm", true);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/profile.jsp");
        dispatcher.forward(req, resp);
    }
}
