package com.ohgiraffers.semiproject.project.model.dto;

public class ProjectCategoryDTO {

    private int code;

    private String name;

    public ProjectCategoryDTO() {
    }

    public ProjectCategoryDTO(int code, String name) {
        this.code = code;
        this.name = name;
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


    @Override
    public String toString() {
        return "ProjectCategoryDTO{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }
}
