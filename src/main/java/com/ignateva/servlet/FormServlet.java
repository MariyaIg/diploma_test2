package com.ignateva.servlet;

import com.ignateva.dao.CompanyDao;
import com.ignateva.entity.Accounts;
import com.ignateva.entity.Company;
import com.ignateva.entity.Rating;
import com.ignateva.entity.User;
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
        float code = Float.parseFloat(req.getParameter("industryCode"));

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
        String user_login = String.valueOf(session.getAttribute("login"));
        User user = userService.findUser(user_login);
        Company company;
               company= formService.SaveCompany(title, taxId, code);
        int industryRisk = formService.calculateIndustryRisk(code);
        Accounts accounts1 = new Accounts(date, company.getId(), sales, operating_profit, net_profit,
                current_assets, current_liabilities, equity, st_debt, lt_debt, tbs);
        Accounts accounts2 = new Accounts(formService.dateConvert(date), company.getId(), sales_2);

        String res = formService.saveAccounts(taxId, date, sales, operating_profit, net_profit,
                current_assets, current_liabilities, equity, st_debt, lt_debt, tbs);
        String res2 = formService.saveAccounts2(taxId, date, sales_2);

        req.setAttribute("taxId", taxId);
        req.setAttribute("title", title);
        req.setAttribute("date", date);
        //req.setAttribute("company",company);

        if (Objects.equals(res, "success") && Objects.equals(res, res2)) {
            int score = formService.calculateScore();
            int finalScore = formService.calculateFinalScore(score,industryRisk);
            req.setAttribute("score", score);
            String position1 = formService.descriptionScore(score);
            String position2 = formService.descriptionScore(finalScore);
            req.setAttribute("position1", position1);
            req.setAttribute("position2", position2);
            req.setAttribute("industryRisk", industryRisk);
            req.setAttribute("finalScore", finalScore);

            long LocalDate= session.getCreationTime();

          company=formService.findCompanyByTaxId(taxId);
          Rating rating=new Rating(date, company.getId(), score, finalScore,user.getId(),new Date(LocalDate));
            req.setAttribute("rating", rating);
         String mess = formService.saveRating(rating);
            req.setAttribute("mess", mess);
            req.getRequestDispatcher("/rating.jsp").forward(req, resp);

        } else {
            req.setAttribute("res", res);
            req.setAttribute("res2", res2);
            req.setAttribute("accounts1", accounts1);
            req.setAttribute("accounts2", accounts2);

            req.getRequestDispatcher("/form.jsp").forward(req, resp);

        }
        /*
        String[] s = req.getParameterValues("check1");
        String[] s2 = req.getParameterValues("check2");

        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s2.length; j++) {
                if (Objects.equals(s[i], "new1")) {
                    formService.updateAccounts_test(accounts1);

                    if (Objects.equals(s[j], "new2")) {
                        formService.updateAccounts2_test(accounts2);
                    }

                    int score = formService.calculateScore();
                    req.setAttribute("score", score);
                    req.getRequestDispatcher("/rating.jsp").forward(req, resp);
                } else {
                    int score = formService.calculateScoreFromBase(taxId, date);

                    req.setAttribute("score", score);
                    req.getRequestDispatcher("/rating.jsp").forward(req, resp);
                }
            }

        }

    }*/
    }
}