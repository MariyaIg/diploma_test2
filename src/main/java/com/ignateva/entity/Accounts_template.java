package com.ignateva.entity;

public class Accounts_template extends Accounts{
    private long sales_2;

    public Accounts_template(String date, int company_id, long sales, long sales_2,long operating_profit, long net_profit, long current_assets, long current_liabilities, long equity,
                             long st_debt, long lt_debt, long tbs) {
        super(date, company_id, sales, operating_profit, net_profit, current_assets, current_liabilities, equity, st_debt, lt_debt, tbs);
        this.sales_2 = sales_2;
    }

    public Accounts_template() {

    }

    public long getSales_2() {
        return sales_2;
    }

    public void setSales_2(long sales_2) {
        this.sales_2 = sales_2;
    }
}
