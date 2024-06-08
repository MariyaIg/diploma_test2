package com.ignateva.service;

import com.ignateva.dao.AccountsDao;
import com.ignateva.dao.IndustryDao;
import com.ignateva.entity.Accounts;
import com.ignateva.entity.Rating;
import com.ignateva.entity.Ratios;

import java.sql.Date;
import java.util.List;

public class CalculationService {
    private static final  double w1= 1;
    private static final double w2= 1;
    private static final double w3= 1;
    private static final double w4= 1;
    private static final double w5= 1;
    Accounts accounts1;

    Accounts accounts2;

    public int getScore() {
        return score;
    }

    int score;



    public CalculationService() {

    }

    public Ratios calculateRatios(Accounts accounts1,Accounts accounts2) {
        Ratios ratios;
        float equity_ratio = (float) accounts1.getEquity() / accounts1.getTbs();
        float liquidity_ratio = (float) accounts1.getCurrent_assets() / accounts1.getCurrent_liabilities();
        float sales_growth = (float) accounts1.getSales() / accounts2.getSales()-1;
        float operating_margin = (float) accounts1.getOperating_profit() / accounts1.getSales();
        float net_margin = (float) accounts1.getNet_profit() / accounts1.getSales();
        float stDebt_burden = (float) (accounts1.getSt_debt()+accounts1.getLt_debt()) / accounts1.getOperating_profit();
        float totalDebt_burden = (float) accounts1.getLt_debt() / accounts1.getOperating_profit();

        return ratios = new Ratios(equity_ratio, liquidity_ratio, sales_growth, operating_margin, net_margin, stDebt_burden, totalDebt_burden);

    }
    public int calculateScore (Ratios ratios){
        double r1;
        double r2;
        double r3;
        double r4;
        double r5;
        if(ratios.getEquity_ratio()>=0.07){
            r1=18*w1;}
        else if (ratios.getEquity_ratio()>=0.03 && ratios.getEquity_ratio()<0.07){
            r1=10*w1;}
        else if (ratios.getEquity_ratio()>0 && ratios.getEquity_ratio()<0.03){
            r1=0;
        } else {
            r1 = -18;}

        if(ratios.getLiquidity_ratio()>=1){
            r2=22*w2;}
        else if (ratios.getLiquidity_ratio()>=0.5 && ratios.getLiquidity_ratio()<1){
            r2=15*w2;
        } else {
            r2 = 0;}

        if(ratios.getSales_growth()>=0.2){
            r3=22*w3;
        }
        else if (ratios.getSales_growth()>0 && ratios.getSales_growth()<0.2){
            r3=15*w3;
        } else {r3 = 0;}

        if(ratios.getOperating_margin()>=0.1){
            r4=16*w4;
        }
        else if (ratios.getOperating_margin()>=0.03 && ratios.getOperating_margin()<0.1){
            r4=15*w4;
        } else {r4 = 0;}

        if(ratios.getNet_margin()>=0.07){
            r5=9*w5;
        }
        else if (ratios.getNet_margin()>=0.01 && ratios.getNet_margin()<0.07){
            r5=5*w5;
        }
        else if (ratios.getNet_margin()>0 && ratios.getNet_margin()<0.01){
                r5=0;
        } else {r5 = -9;}

        return score= (int) (r1+ r2 +r3 + r4+ r5);
    }

    public int calculateIndustryRiskById(int company_id){
        int risk= new IndustryDao().getIndustryRiskById(company_id);

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

    public Rating calculateRatingFromBase(String taxId, String date, int user_id, Date localdate) {
        AccountsDao accountsDao = new AccountsDao();
        FormService formService= new FormService();
        Accounts accounts1 = accountsDao.findByDate(date, taxId);
        String date_2 = formService.dateConvert(date);
        Accounts accounts2 = accountsDao.findByDate(date_2, taxId);

        return calculateRating(accounts1,accounts2,user_id,localdate);
    }
    public Rating calculateRating(Accounts accounts1, Accounts accounts2, int user_id, Date date){
        int financial_score = calculateScore(calculateRatios(accounts1,accounts2));
        int total_score = calculateFinalScore(financial_score,calculateIndustryRiskById(accounts1.getCompany_id()));
        return new Rating(accounts1.getDate(),accounts1.getCompany_id(),financial_score, total_score,user_id,date);

    }


}

