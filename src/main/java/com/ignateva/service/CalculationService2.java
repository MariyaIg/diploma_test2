package com.ignateva.service;

import com.ignateva.dao.AccountsDao;
import com.ignateva.dao.IndustryDao;
import com.ignateva.entity.Accounts;
import com.ignateva.entity.Rating;
import com.ignateva.entity.Ratios;

import java.sql.Date;
// СКОРРЕКТИРОВАНО, НАСТОЯЩИЙ РАСЧЕТ НЕ ПРЕДОСТАВЛЯЕТСЯ- КОНФИДЕНЦИАЛЬНО
public class CalculationService2 {

        private static final  double w1= 1;
        private static final double w2= 1;
        private static final double w3= 1;
        private static final double w4= 1;
        private static final double w5= 1;


        public int getScore() {
            return score;
        }

        int score;



        public Ratios calculateRatios(Accounts accounts1, Accounts accounts2) {
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
            double r1= Math.random()*10;
            double r2 =Math.random()*10;
            double r3 =Math.random()*10;
            double r4 = Math.random()*10;
            double r5 =Math.random()*10;
            double r6 =Math.random()*10;
            //настоящие формулы не раскрываются

            return score= (int) (r1+ r2 +r3 + r4+ r5+ r6);
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
            //настоящий расчет не раскрывается
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


        public String descriptionRisk(int risk) {
            String riskDescription;
            if (risk == 1){
                riskDescription ="низкий";
            }
            else if (risk == 2){
                riskDescription ="средний";
            }
            else if (risk == 3){
                riskDescription ="высокий";
            }
            else  riskDescription ="not";

            return riskDescription;
        }

}
