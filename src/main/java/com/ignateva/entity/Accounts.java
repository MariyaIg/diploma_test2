package com.ignateva.entity;

import java.sql.Date;

public class Accounts {
    private int id;
    private String date;
    private int company_id;
    private long sales;
    private long operating_profit;
    private long net_profit;
    private long current_assets;
    private long current_liabilities;
    private long equity;
    private long st_debt;
    private long lt_debt;
    private long tbs;

    public void setId(int id) {
        this.id = id;
    }

    public Accounts(int id, String date, int company_id, long sales, long operating_profit, long net_profit, long current_assets, long current_liabilities, long equity, long st_debt, long lt_debt, long tbs) {
        this.id = id;
        this.date = date;
        this.company_id = company_id;
        this.sales = sales;
        this.operating_profit = operating_profit;
        this.net_profit = net_profit;
        this.current_assets = current_assets;
        this.current_liabilities = current_liabilities;
        this.equity = equity;
        this.st_debt = st_debt;
        this.lt_debt = lt_debt;
        this.tbs = tbs;
    }

    public Accounts(String date, int company_id, long sales) {
        this.date = date;
        this.company_id = company_id;
        this.sales = sales;
    }

    public Accounts(String date, int company_id, long sales, long operating_profit, long net_profit, long current_assets, long current_liabilities, long equity, long st_debt, long lt_debt, long tbs) {
        this.date = date;
        this.company_id = company_id;
        this.sales = sales;
        this.operating_profit = operating_profit;
        this.net_profit = net_profit;
        this.current_assets = current_assets;
        this.current_liabilities = current_liabilities;
        this.equity = equity;
        this.st_debt = st_debt;
        this.lt_debt = lt_debt;
        this.tbs = tbs;
    }

    public Accounts() {

    }

    public int getId() {
        return id;
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

    public long getSales() {
        return sales;
    }

    public void setSales(long sales) {
        this.sales = sales;
    }

    public long getOperating_profit() {
        return operating_profit;
    }

    public void setOperating_profit(long operating_profit) {
        this.operating_profit = operating_profit;
    }

    public long getNet_profit() {
        return net_profit;
    }

    public void setNet_profit(long net_profit) {
        this.net_profit = net_profit;
    }

    public long getCurrent_assets() {
        return current_assets;
    }

    public void setCurrent_assets(long current_assets) {
        this.current_assets = current_assets;
    }

    public long getCurrent_liabilities() {
        return current_liabilities;
    }

    public void setCurrent_liabilities(long current_liabilities) {
        this.current_liabilities = current_liabilities;
    }

    public long getEquity() {
        return equity;
    }

    public void setEquity(long equity) {
        this.equity = equity;
    }

    public long getSt_debt() {
        return st_debt;
    }

    public void setSt_debt(long st_debt) {
        this.st_debt = st_debt;
    }

    public long getLt_debt() {
        return lt_debt;
    }

    public void setLt_debt(long lt_debt) {
        this.lt_debt = lt_debt;
    }

    public long getTbs() {
        return tbs;
    }

    public void setTbs(long tbs) {
        this.tbs = tbs;
    }
}
