package com.ignateva.servlet;

import com.ignateva.entity.CompanyResult;
import com.ignateva.service.AnalyticService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet (value = "/showCompany-servlet")
public class ShowCompanyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CompanyResult companyResult =new CompanyResult();
        String taxId = req.getParameter("taxId");
        AnalyticService analyticService = new AnalyticService();
        companyResult=analyticService.getCompanyResult(taxId);
        req.setAttribute("companyResult",companyResult);

        req.getRequestDispatcher("/showCompanyResult.jsp").forward(req, resp);
    }
}
