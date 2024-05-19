package com.ignateva.servlet;

import com.ignateva.entity.User;
import com.ignateva.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (name = "UserRegistrationServlet",value = "/userRegistration-servlet")
public class UserRegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.getRequestDispatcher("/registration.html").forward(req, resp);
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String pass = req.getParameter("pass");
        User user = new User();
        user.setName(name);
        user.setLogin(login);
        user.setPass(pass);

        UserService userService = new UserService();
        userService.createUser(user);
        req.getRequestDispatcher("/views/user/enter_page.html").forward(req, resp);


    }
}
