package com.ignateva.servlet;

import com.ignateva.service.FormService;
import com.ignateva.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="DeleteCompanyServlet", value = "/deleteCompany-servlet")
public class DeleteCompanyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String taxId = req.getParameter("taxId");

        FormService formService = new FormService();

        formService.deleteCompany(taxId);
        req.getRequestDispatcher("/admin.jsp").forward(req, resp);
    }
}

