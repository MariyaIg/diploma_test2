package com.ignateva.servlet;

import com.ignateva.service.FormService;
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
        req.getRequestDispatcher("/admin.jsp").forward(req, resp);
        String filePath = req.getParameter("filePath");
        FormService formService=new FormService();

        String mess = formService.createIndustriesFromFile(filePath);

    }
}
