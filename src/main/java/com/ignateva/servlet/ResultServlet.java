package com.ignateva.servlet;

import com.ignateva.entity.*;
import com.ignateva.service.CalculationService;
import com.ignateva.service.FormService;
import com.ignateva.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Objects;

@WebServlet(value = "/result-servlet")
public class ResultServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FormService formService = new FormService();
        HttpSession session = req.getSession();
        UserService userService = new UserService();
        CalculationService calculationService = new CalculationService();
        long LocalDate = session.getCreationTime();
        String user_login = String.valueOf(session.getAttribute("login"));
        User user = userService.findUser(user_login);

        String s = req.getParameter("check1");
        String s2 = req.getParameter("check2");
        Accounts_template accounts_template = formService.getAllTemplate();
        Company company = formService.findCompanyById(accounts_template.getCompany_id());
        req.setAttribute("taxId", company.getTaxId());
        req.setAttribute("title", company.getTitle());
        req.setAttribute("date", accounts_template.getDate());
        Rating rating = new Rating();
        if ("old1".equals(s) && "old2".equals(s2)) {
            //проверить может есть посчитанный рейтинг уже, если нет,то далее
            rating = calculationService.calculateRatingFromBase(company.getTaxId(), accounts_template.getDate(), user.getId(), new Date(LocalDate));


        }
        if ("new1".equals(s) && "new2".equals(s2)) {
            Accounts accounts1 = new Accounts(accounts_template.getDate(), accounts_template.getCompany_id(), accounts_template.getSales(),
                    accounts_template.getOperating_profit(), accounts_template.getNet_profit(), accounts_template.getCurrent_assets(),
                    accounts_template.getCurrent_liabilities(), accounts_template.getEquity(), accounts_template.getSt_debt(),
                    accounts_template.getLt_debt(), accounts_template.getTbs());
            Accounts accounts2 = new Accounts(formService.dateConvert(accounts_template.getDate()), accounts_template.getCompany_id(),
                    accounts_template.getSales_2());
            rating = calculationService.calculateRating(accounts1, accounts2, user.getId(), new Date(LocalDate));

            formService.updateAccounts(accounts1);
            formService.updateAccounts2(accounts2);

        }
        if ("new1".equals(s) && "old2".equals(s2)) {
            Accounts accounts1 = new Accounts(accounts_template.getDate(), accounts_template.getCompany_id(), accounts_template.getSales(),
                    accounts_template.getOperating_profit(), accounts_template.getNet_profit(), accounts_template.getCurrent_assets(),
                    accounts_template.getCurrent_liabilities(), accounts_template.getEquity(), accounts_template.getSt_debt(),
                    accounts_template.getLt_debt(), accounts_template.getTbs());
            formService.updateAccounts(accounts1);

            Accounts accounts2 = formService.selectAccountsFromBase(accounts_template);
            rating = calculationService.calculateRating(accounts1, accounts2, user.getId(), new Date(LocalDate));
        }
        if ("old1".equals(s) && "new2".equals(s2)) {
            Accounts accounts1 = formService.selectAccountsFromBase(accounts_template);
            Accounts accounts2 = new Accounts(formService.dateConvert(accounts_template.getDate()), accounts_template.getCompany_id(),
                    accounts_template.getSales_2());
            formService.updateAccounts2(accounts2);
            rating = calculationService.calculateRating(accounts1, accounts2, user.getId(), new Date(LocalDate));

        }
        req.setAttribute("rating", rating);
        String mess = formService.saveRating(rating);
        req.setAttribute("mess", mess);
       formService.deleteAccountsTemplate(accounts_template);
        String position1 = calculationService.descriptionScore(rating.getFinancial_score());
        String position2 = calculationService.descriptionScore(rating.getTotal_score());
        req.setAttribute("position1", position1);
        req.setAttribute("position2", position2);
        req.setAttribute("IndustryRisk", calculationService.calculateIndustryRiskById(company.getId()));
        req.getRequestDispatcher("/rating.jsp").forward(req, resp);

    }
}

