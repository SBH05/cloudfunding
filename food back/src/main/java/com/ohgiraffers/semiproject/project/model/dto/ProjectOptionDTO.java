package com.ohgiraffers.semiproject.project.model.dto;

public class ProjectOptionDTO {

    private int code;

    private String name;

    private String type;

    private int price;

    private String config;

    private ProjectDTO projectCode;

    public ProjectOptionDTO() {
    }

    public ProjectOptionDTO(int code, String name, String type, int price, String config, ProjectDTO projectCode) {
        this.code = code;
        this.name = name;
        this.type = type;
        this.price = price;
        this.config = config;
        this.projectCode = projectCode;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public ProjectDTO getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(ProjectDTO projectCode) {
        this.projectCode = projectCode;
    }

    @Override
    public String toString() {
        return "ProjectOptionDTO{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", config='" + config + '\'' +
                ", projectCode=" + projectCode +
                '}';
    }
}
