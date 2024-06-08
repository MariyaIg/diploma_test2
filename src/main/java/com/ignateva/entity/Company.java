package com.ignateva.entity;

public class Company {
    private int id;
    private String title;
    private String taxId;
    private int industry_id;

    public void setId(int id) {
        this.id = id;
    }

    public Company() {

    }

    public Company(String title, String taxId, int industry_id) {
        this.title = title;
        this.taxId = taxId;
        this.industry_id = industry_id;
    }

    public Company(int id, String title, String taxId, int industry_id) {
        this.id = id;
        this.title = title;
        this.taxId = taxId;
        this.industry_id = industry_id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public int getIndustry_id() {
        return industry_id;
    }

    public void setIndustry_id(int industry_id) {
        this.industry_id = industry_id;
    }
}
