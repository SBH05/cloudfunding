package com.ohgiraffers.semiproject.manager.model.dto;

import lombok.*;

import java.sql.Date;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class PrivateBusinessDTO {

    private int businessCode;
    private String businessName;
    private String industry;
    private Date establishmentDate;
    private String homepage;
    private String location;
    private String businessPhone;
    private String businessLicenseNumber;
    private int userCode;
    private String businessEmail;
}
