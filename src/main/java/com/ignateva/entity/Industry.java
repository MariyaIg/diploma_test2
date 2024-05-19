package com.ignateva.entity;

import java.util.Objects;

public class Industry {
    private int id;
    private String title;
    private float code;
    private int risk;

    public int getRisk() {
        return risk;
    }

    public void setRisk(int risk) {
        this.risk = risk;
    }

    public Industry(String title, float code) {
        this.title = title;
        this.code = code;
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
                ", code='" + code + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, code);
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

    public float getCode() {
        return code;
    }

    public void setCode(float code) {
        this.code = code;
    }
}
