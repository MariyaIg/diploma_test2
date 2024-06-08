package com.ignateva.servlet;

import com.ignateva.service.FormService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="DeleteAccountsServlet", value = "/deleteAccounts-servlet")
public class DeleteAccountsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String taxId = req.getParameter("taxId");
        String date = req.getParameter("date");
        FormService formService = new FormService();

        formService.deleteAccounts(date,taxId);
        req.getRequestDispatcher("/admin.jsp").forward(req, resp);
    }
}

