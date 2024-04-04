package com.ohgiraffers.semiproject.project.model.dto;

public class PlanDTO {

    private int code;

    private String name;

    private int price;

    private String detail;

    public PlanDTO() {
    }

    public PlanDTO(int code, String name, int price, String detail) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.detail = detail;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "PlanDTO{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", detail='" + detail + '\'' +
                '}';
    }
}
