package com.ignateva.servlet;

import com.ignateva.dao.UserDao;
import com.ignateva.entity.User;
import com.ignateva.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindUserServlet", value = "/findUser-servlet")
public class FindUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.getRequestDispatcher("/admin.jsp").forward(req, resp);
        String login = req.getParameter("login3");

        UserDao userDao = new UserDao();

       User user = userDao.findUserByLogin(login);
        req.setAttribute("res", user);
        req.getRequestDispatcher("/admin.jsp").forward(req, resp);
    }
}


