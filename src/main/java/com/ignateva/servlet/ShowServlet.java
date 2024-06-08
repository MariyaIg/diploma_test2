package com.ignateva.servlet;

import com.ignateva.entity.CompanyResult;
import com.ignateva.service.AnalyticService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet (value = "/show-servlet")
public class ShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CompanyResult> companyResults = new ArrayList<>();
        AnalyticService analyticService=new AnalyticService();
       companyResults= analyticService.getCompanyList();
        req.setAttribute("listOfCompanies",companyResults);

        req.getRequestDispatcher("/showAll.jsp").forward(req, resp);
    }


}
