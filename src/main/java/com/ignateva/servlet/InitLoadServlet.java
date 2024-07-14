package com.ignateva.servlet;


import com.ignateva.service.LoadService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/InitLoad-servlet")
public class InitLoadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/admin.html").forward(req, resp);
        String filePath = req.getParameter("filePath");
        LoadService loadService=new LoadService();
        String mess = loadService.createIndustriesFromFile(filePath);

    }
}
