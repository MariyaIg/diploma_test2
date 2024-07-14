package com.ignateva.servlet;

import com.ignateva.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "UpdateUserServlet", value ="/updateUser-servlet")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login_upd = req.getParameter("login1");
        String pass = req.getParameter("pass");

        UserService userService = new UserService();
        userService.updateUser(login_upd, pass);
        req.getRequestDispatcher("/admin.html").forward(req, resp);
    }
}
