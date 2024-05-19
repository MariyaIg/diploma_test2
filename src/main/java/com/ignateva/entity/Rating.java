package com.ignateva.entity;

import java.sql.Date;

public class Rating {
    private int id;
    private String date;
    private int company_id;
    private int financial_score;
    private int total_score;
    private int user_id;
    private Date calculation_date;

    public Rating(String date, int company_id, int financial_score, int total_score, int user_id, Date calculation_date) {
        this.date = date;
        this.company_id = company_id;
        this.financial_score = financial_score;
        this.total_score = total_score;
        this.user_id = user_id;
        this.calculation_date = calculation_date;
    }

    public Rating() {

    }

    public Date getCalculation_date() {
        return calculation_date;
    }

    public void setCalculation_date(Date calculation_date) {
        this.calculation_date = calculation_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public int getFinancial_score() {
        return financial_score;
    }

    public void setFinancial_score(int financial_score) {
        this.financial_score = financial_score;
    }

    public int getTotal_score() {
        return total_score;
    }

    public void setTotal_score(int total_score) {
        this.total_score = total_score;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
