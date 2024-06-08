package com.ignateva.servlet;

import com.ignateva.entity.Industry;
import com.ignateva.parser.ReadExlFile;
import com.ignateva.service.FormService;
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
        req.getRequestDispatcher("/admin.jsp").forward(req, resp);
        String filePath = req.getParameter("filePath");
        FormService formService=new FormService();

        String mess = formService.updateIndustriesFromFile(filePath);

        HttpSession session = req.getSession();
        Integer progress = 0;
        if ((session != null) &&
                session.getAttribute("Progress") != null)
            progress = (Integer) session.getAttribute("Progress");

        progress += 10;
        session.setAttribute("Progress", progress);

        resp.setContentType("text/plain");
        resp.getWriter().write(String.valueOf(progress));
    }
}


