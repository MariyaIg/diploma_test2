package com.ignateva.entity;

import java.util.Objects;

public class Industry {
    private int id;
    private String title;
    private String code;
    private int risk;

    public int getRisk() {
        return risk;
    }

    public void setRisk(int risk) {
        this.risk = risk;
    }

    public Industry(String title, String code) {
        this.title = title;
        this.code = code;
    }

    public Industry() {
    }

    public Industry(String title, String code, int risk) {
        this.title = title;
        this.code = code;
        this.risk = risk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Industry industry = (Industry) o;
        return Objects.equals(title, industry.title) && Objects.equals(code, industry.code);
    }

    @Override
    public String toString() {
        return "Industry{" +
                "title='" + title + '\'' +
                ", code=" + code +
                ", risk=" + risk +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, code, risk);
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
