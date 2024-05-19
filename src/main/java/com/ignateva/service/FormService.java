package com.ignateva.service;

import com.ignateva.dao.AccountsDao;
import com.ignateva.dao.CompanyDao;
import com.ignateva.dao.IndustryDao;
import com.ignateva.dao.RatingDao;
import com.ignateva.entity.Accounts;
import com.ignateva.entity.Company;
import com.ignateva.entity.Rating;
import com.ignateva.entity.Ratios;

import java.sql.Date;

public class FormService {
    CompanyDao companyDao = new CompanyDao();
    Accounts accounts1;
    Accounts accounts2;
    public Company SaveCompany(String title, String taxId, float code) {
        Company company;
        if (companyDao.findByTaxId(taxId)== null) {

            IndustryDao industryDao = new IndustryDao();
            int industry_id = industryDao.getIndustryId(code);
            company = new Company(title, taxId, industry_id);

            companyDao.save(company);
        } else company=companyDao.findByTaxId(taxId);
        return company;
    }
    public Company findCompanyByTaxId(String taxId){
        return companyDao.findByTaxId(taxId);
    }

    public String dateConvert(String date){
       String date2 = "";
        int d = Integer.parseInt(date.substring(0,4));
        String c = date.substring(4,10);
       int a= d-1;
       date2=a+c;
        return date2;
    }
    public String saveAccounts(String taxId, String date, long sales, long operating_profit, long net_profit,
                             long current_assets, long current_liabilities, long equity, long st_debt, long lt_debt, long tbs) {
        AccountsDao accountsDao = new AccountsDao();
        String message1="";
        Company company = companyDao.findByTaxId(taxId);
        if (accountsDao.findByDate(taxId, date) == null) {
            accounts1=new Accounts(date, company.getId(), sales, operating_profit, net_profit, current_assets,
                    current_liabilities, equity, st_debt, lt_debt, tbs);
            accountsDao.save(accounts1);
            message1 = "success";
        } else {

            message1 = "отчетность за текущий период этой компании уже существует";
        }
        return message1;
    }
    public String saveAccounts2 (String taxId, String date,long sales_2) {
        AccountsDao accountsDao = new AccountsDao();

        String message2="";
        Company company = companyDao.findByTaxId(taxId);
        String date_2 = dateConvert(date);
        if (accountsDao.findByDate(taxId, date_2) == null) {
            accounts2=new Accounts(date_2, company.getId(), sales_2, 0, 0, 0,
                    0, 0, 0, 0, 0);
            accountsDao.save(accounts2);
           message2 = "success";
        }
         else {
            message2 = "отчетность за прошлый период этой компании уже существует";
        }
        return message2;
    }

    public void updateAccounts(String taxId, String date, long sales, long operating_profit, long net_profit,
                               long current_assets, long current_liabilities, long equity, long st_debt, long lt_debt, long tbs) {
        AccountsDao accountsDao = new AccountsDao();
        Company company = companyDao.findByTaxId(taxId);
        accounts1=new Accounts(date, company.getId(), sales, operating_profit, net_profit, current_assets,
                current_liabilities, equity, st_debt, lt_debt, tbs);
        accountsDao.update(accounts1);
    }
    public void updateAccounts_test(Accounts accounts) {
        AccountsDao accountsDao = new AccountsDao();
        accounts1=accounts;
        accountsDao.update(accounts1);
    }
    public void updateAccounts2(String taxId, String date, long sales_2){
        AccountsDao accountsDao = new AccountsDao();
        String date_2 = dateConvert(date);
        Company company = companyDao.findByTaxId(taxId);
        accountsDao.update2(company.getId(), date_2, sales_2);
        accounts2=accountsDao.findByDate(taxId, date_2);
    }
    public void updateAccounts2_test(Accounts accounts){
        AccountsDao accountsDao = new AccountsDao();

        accountsDao.update2(accounts.getCompany_id(), accounts.getDate(), accounts.getSales());
        accounts2=accounts;
    }


    public int calculateScore(){
        CalculationService calculationService=new CalculationService(accounts1,accounts2);
        Ratios ratios= calculationService.calculateRatios();
        return calculationService.calculateScore(ratios);
    }
    public int calculateScoreFromBase(String taxId, String date){
        AccountsDao accountsDao = new AccountsDao();
        accounts1= accountsDao.findByDate(taxId,date);
        String date_2 = dateConvert(date);
        accounts2= accountsDao.findByDate(taxId,date_2);

    return calculateScore();
    }

    public void deleteCompany(String taxId){
        companyDao.DeleteCompany(taxId);
    }

    public void deleteAccounts (String taxId, String date){
       AccountsDao accountsdao =new AccountsDao();
       Accounts accounts= accountsdao.findByDate(taxId,date);
       accountsdao.delete(accounts.getId());
    }
    public int calculateIndustryRisk(float code){
        int risk= new IndustryDao().getIndustryRisk(code);

        return risk;
    }

    public int calculateFinalScore(int score, int industryRisk) {
        int finalScore=0;
        if (industryRisk == 1){
            finalScore = score+10;
        }
        else if (industryRisk == 2){
            finalScore = score+5;
        }
        else  finalScore = score -5;
        return finalScore;
    }
    public String descriptionScore(int score){
        String position="";
        if (score<=30) position ="плохое";
        else if (score>50) position ="хорошее";
        else position ="среднее";

        return position;
    }

    public String saveRating(Rating rating){
        String mess;
           RatingDao ratingDao = new RatingDao();
            if (ratingDao.find(rating.getCompany_id(), rating.getDate())==null) {
                ratingDao.saveRating(rating);
                mess = "success";
            }
            else mess = "рейтинг уже существует";

            return mess;
        }
    }

