package com.ohgiraffers.semiproject.member.model.dto;

public class AuthorityDTO {

    private int authorityCode;
    private String authorityName;
    private String authorityDescription;

    public AuthorityDTO() {
    }

    public AuthorityDTO(int authorityCode, String authorityName, String authorityDescription) {
        this.authorityCode = authorityCode;
        this.authorityName = authorityName;
        this.authorityDescription = authorityDescription;
    }

    public int getAuthorityCode() {
        return authorityCode;
    }

    public void setAuthorityCode(int authorityCode) {
        this.authorityCode = authorityCode;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    public String getAuthorityDescription() {
        return authorityDescription;
    }

    public void setAuthorityDescription(String authorityDescription) {
        this.authorityDescription = authorityDescription;
    }


    @Override
    public String toString() {
        return "AuthorityDTO{" +
                "authorityCode=" + authorityCode +
                ", authorityName='" + authorityName + '\'' +
                ", authorityDescription='" + authorityDescription + '\'' +
                '}';
    }
}
