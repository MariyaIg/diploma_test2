package com.ignateva.service;

import com.ignateva.dao.AccountsDao;
import com.ignateva.dao.CompanyDao;
import com.ignateva.dao.IndustryDao;
import com.ignateva.dao.RatingDao;
import com.ignateva.entity.*;
import com.ignateva.parser.ReadExlFile;
import com.ignateva.parser.ReadExlFile2;
import com.ignateva.parser.ReadExlFile3;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.ignateva.parser.ReadExlFile3.parseFile;

public class FormService {
    CompanyDao companyDao = new CompanyDao();
    AccountsDao accountsDao = new AccountsDao();

    public Company SaveCompany(String title, String taxId, String code) {
        Company company;
        if (companyDao.findByTaxId(taxId) == null) {

            IndustryDao industryDao = new IndustryDao();
            int industry_id = industryDao.getIndustryId(code);
            company = new Company(title, taxId, industry_id);
            companyDao.save(company);
            company = companyDao.findByTaxId(taxId);
        } else company = companyDao.findByTaxId(taxId);
        return company;
    }

    public Company findCompanyByTaxId(String taxId) {
        return companyDao.findByTaxId(taxId);
    }

    public Company findCompanyById(int id) {
        return companyDao.findById(id);
    }

    public String dateConvert(String date) {
        String date2 = "";
        int d = Integer.parseInt(date.substring(0, 4));
        String c = date.substring(4, 10);
        int a = d - 1;
        date2 = a + c;
        return date2;
    }

    public String saveAccounts(Accounts accounts1, String taxId) {
        Company company = companyDao.findById(accounts1.getCompany_id());
        String message1;
        if (accountsDao.findByDate(accounts1.getDate(), taxId) == null) {

            accountsDao.save(accounts1);
            message1 = "success";
        } else {

            message1 = "отчетность за текущий период этой компании уже существует";
        }
        return message1;
    }

    public String saveAccounts2(Accounts accounts2, String taxId) {
        Company company = companyDao.findById(accounts2.getCompany_id());
        String message2;

        if (accountsDao.findByDate(accounts2.getDate(), taxId) == null) {
            Accounts accounts = new Accounts(accounts2.getDate(), accounts2.getCompany_id(), accounts2.getSales(), 0, 0, 0,
                    0, 0, 0, 0, 0);
            accountsDao.save(accounts);
            message2 = "success";
        } else {
            message2 = "отчетность за прошлый период этой компании уже существует";
        }
        return message2;
    }

    public void save_accounts_template(Accounts_template accounts_template) {
        accountsDao.save_temp(accounts_template);
    }

    public void updateAccounts(Accounts accounts1) {
        AccountsDao accountsDao = new AccountsDao();

        accountsDao.update1(accounts1);
    }

    public Accounts_template getAllTemplate() {
        return accountsDao.selectTemplate();
    }

    public void updateAccounts2(Accounts accounts2) {
        AccountsDao accountsDao = new AccountsDao();

        accountsDao.update2(accounts2);
    }

    public Accounts selectAccountsFromBase(Accounts accounts) {
        String date = accounts.getDate();
        String taxId = companyDao.findById(accounts.getCompany_id()).getTaxId();
        return accountsDao.findByDate(date, taxId);
    }

    /*public void updateAccounts2(String taxId, String date, long sales_2){
        AccountsDao accountsDao = new AccountsDao();
        String date_2 = dateConvert(date);
        Company company = companyDao.findByTaxId(taxId);
        accountsDao.update2(company.getId(), date_2, sales_2);
       Accounts accounts2=accountsDao.findByDate(taxId, date_2);
    }
    public void updateAccounts2_test(Accounts accounts){
        AccountsDao accountsDao = new AccountsDao();

        accountsDao.update2(accounts.getCompany_id(), accounts.getDate(), accounts.getSales());

    }



    */

    public void deleteCompany(String taxId) {
        companyDao.DeleteCompany(taxId);
    }

    public void deleteAccounts(String taxId, String date) {
        AccountsDao accountsdao = new AccountsDao();

        accountsdao.delete(accountsdao.findByDate(taxId, date).getId());
    }

    public void deleteAccountsTemplate(Accounts accounts_template) {
        AccountsDao accountsdao = new AccountsDao();

        accountsdao.deleteTemplate(accounts_template.getCompany_id());
    }


    public String saveRating(Rating rating) {
        String mess;
        RatingDao ratingDao = new RatingDao();
        if (ratingDao.find(rating.getCompany_id(), rating.getDate()) == null) {
            ratingDao.saveRating(rating);
            mess = "успешно сохранен";
        } else {
            ratingDao.updateRating(rating);
            mess = "рейтинг перезаписан";
        }

        return mess;
    }



}


