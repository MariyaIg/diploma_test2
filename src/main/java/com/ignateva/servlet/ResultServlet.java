package com.ignateva.servlet;

import com.ignateva.entity.Rating;
import com.ignateva.service.FormService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/result-servlet")
public class ResultServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/form.jsp").forward(req, resp);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FormService formService = new FormService();
        String title = req.getParameter("title");
        String taxId = req.getParameter("taxId");
        String date = (req.getParameter("date"));

        int score = formService.calculateScoreFromBase(taxId, date);

     //   formService.saveRating(rating);
        req.setAttribute("score", score);
        req.setAttribute("taxId", taxId);
        req.setAttribute("title", title);
        req.setAttribute("date", date);
        req.getRequestDispatcher("/rating.jsp").forward(req, resp);
    }


}
