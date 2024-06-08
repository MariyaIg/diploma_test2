package com.ignateva.servlet;

import com.ignateva.dao.CompanyDao;
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
import java.sql.Date;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Objects;

@WebServlet (name = "FormServlet", value ="/form-servlet")
public class FormServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/form.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String taxId = req.getParameter("taxId");
       String code = req.getParameter("industryCode");

        String date = (req.getParameter("date"));

        long current_assets = Long.parseLong(req.getParameter("1200"));
        long equity = Long.parseLong(req.getParameter("1300"));
        long current_liabilities = Long.parseLong(req.getParameter("1500"));
        long lt_debt = Long.parseLong(req.getParameter("1410"));
        long st_debt = Long.parseLong(req.getParameter("1510"));
        long tbs = Long.parseLong(req.getParameter("1700"));
        long sales = Long.parseLong(req.getParameter("2110"));
        long sales_2 = Long.parseLong(req.getParameter("2110_2"));
        long operating_profit = Long.parseLong(req.getParameter("2200"));
        long net_profit = Long.parseLong(req.getParameter("2400"));

        HttpSession session = req.getSession();
        UserService userService=new UserService();
        FormService formService=new FormService();
        CalculationService calculationService= new CalculationService();

        String user_login = String.valueOf(session.getAttribute("login"));
        User user = userService.findUser(user_login);
        Company company= formService.SaveCompany(title, taxId, code);

        Accounts_template accounts_template = new Accounts_template(date, company.getId(), sales, sales_2, operating_profit, net_profit,
                current_assets, current_liabilities, equity, st_debt, lt_debt, tbs);
        Accounts accounts1 = new Accounts(date, company.getId(), sales, operating_profit, net_profit,
                current_assets, current_liabilities, equity, st_debt, lt_debt, tbs);
        Accounts accounts2 = new Accounts(formService.dateConvert(date), company.getId(), sales_2);


        String res = formService.saveAccounts(accounts1,taxId);
        String res2 = formService.saveAccounts2(accounts2,taxId);
        long LocalDate= session.getCreationTime();

        req.setAttribute("taxId", taxId);
        req.setAttribute("title", title);
        req.setAttribute("date", date);
        //req.setAttribute("company",company);

        if (Objects.equals(res, "success") && Objects.equals(res, res2)) {
            Rating rating= calculationService.calculateRating(accounts1,accounts2,user.getId(),new Date(LocalDate));
          String mess = formService.saveRating(rating);
            req.setAttribute("mess", mess);
            req.setAttribute("rating", rating);
            String position1 = calculationService.descriptionScore(rating.getFinancial_score());
            String position2 = calculationService.descriptionScore(rating.getTotal_score());
            req.setAttribute("position1", position1);
            req.setAttribute("position2", position2);
            req.setAttribute("IndustryRisk", calculationService.calculateIndustryRiskById(company.getId()));
            req.getRequestDispatcher("/rating.jsp").forward(req, resp);

        } else {
            req.setAttribute("res", res);
            req.setAttribute("res2", res2);
          formService.save_accounts_template(accounts_template);

            req.getRequestDispatcher("/form.jsp").forward(req, resp);

        }

    }
}