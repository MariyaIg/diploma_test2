package com.ignateva.servlet;

import com.ignateva.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name ="DeleteUserServlet" , value = "/deleteUser-servlet")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login_del = req.getParameter("login2");
        UserService userService = new UserService();
        userService.deleteUser(login_del);
        req.getRequestDispatcher("/admin.html").forward(req, resp);
    }
}


