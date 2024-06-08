package com.ignateva.entity;

public class CompanyResult extends Company{
    private int final_score;
    private int industry_risk;
    private String accounts_date;
   private String taxId;
    private String title;
    public CompanyResult() {

    }

    @Override
    public String getTaxId() {
        return taxId;
    }

    @Override
    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    public int getFinal_score() {
        return final_score;
    }

    public void setFinal_score(int final_score) {
        this.final_score = final_score;
    }

    public int getIndustry_risk() {
        return industry_risk;
    }

    public void setIndustry_risk(int industry_risk) {
        this.industry_risk = industry_risk;
    }

    public String getAccounts_date() {
        return accounts_date;
    }

    public void setAccounts_date(String accounts_date) {
        this.accounts_date = accounts_date;
    }

    public CompanyResult(String taxId, String title, int final_score, int industry_risk, String accounts_date) {
        this.title = title;
        this.taxId = taxId;
        this.final_score = final_score;
        this.industry_risk = industry_risk;
        this.accounts_date = accounts_date;
    }

}
