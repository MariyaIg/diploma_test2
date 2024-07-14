package com.ignateva.servlet;



import com.ignateva.service.LoadService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Map;

@WebServlet(value = "/loadFilePath-servlet")
public class LoadFilePathServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/admin.html").forward(req, resp);
        String filePath = req.getParameter("filePath");
        LoadService loadService =new LoadService();
        String mess = loadService.updateIndustriesFromFile(filePath);

    }
}


