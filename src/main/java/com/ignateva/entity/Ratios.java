package com.ignateva.entity;

public class Ratios {

    private float equity_ratio;
    private float liquidity_ratio;
    private float sales_growth;
    private float operating_margin;
    private float net_margin;
    private float stDebt_burden;
    private float ltDebt_burden;

    public Ratios(float equity_ratio, float liquidity_ratio, float sales_growth,
                  float operating_margin, float net_margin, float stDebt_burden,
                  float ltDebt_burden) {
        this.equity_ratio = equity_ratio;
        this.liquidity_ratio = liquidity_ratio;
        this.sales_growth = sales_growth;
        this.operating_margin = operating_margin;
        this.net_margin = net_margin;
        this.stDebt_burden = stDebt_burden;
        this.ltDebt_burden = ltDebt_burden;
    }

    public float getEquity_ratio() {
        return equity_ratio;
    }

    public void setEquity_ratio(float equity_ratio) {
        this.equity_ratio = equity_ratio;
    }

    public float getLiquidity_ratio() {
        return liquidity_ratio;
    }

    public void setLiquidity_ratio(float liquidity_ratio) {
        this.liquidity_ratio = liquidity_ratio;
    }

    public float getSales_growth() {
        return sales_growth;
    }

    public void setSales_growth(float sales_growth) {
        this.sales_growth = sales_growth;
    }

    public float getOperating_margin() {
        return operating_margin;
    }

    public void setOperating_margin(float operating_margin) {
        this.operating_margin = operating_margin;
    }

    public float getNet_margin() {
        return net_margin;
    }

    public void setNet_margin(float net_margin) {
        this.net_margin = net_margin;
    }

    public float getStDebt_burden() {
        return stDebt_burden;
    }

    public void setStDebt_burden(float stDebt_burden) {
        this.stDebt_burden = stDebt_burden;
    }

    public float getLtDebt_burden() {
        return ltDebt_burden;
    }

    public void setLtDebt_burden(float ltDebt_burden) {
        this.ltDebt_burden = ltDebt_burden;
    }
}
