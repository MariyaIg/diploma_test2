package com.ignateva.servlet;

import com.ignateva.entity.CompanyResult;
import com.ignateva.entity.User;
import com.ignateva.service.AnalyticService;
import com.ignateva.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet (value = "/showAllUsers-servlet")
public class ShowAllUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = new ArrayList<>();
        UserService userService=new UserService();
       users= userService.getAll();
        req.setAttribute("users",users);

        req.getRequestDispatcher("/showAllUsers.jsp").forward(req, resp);
    }


}
