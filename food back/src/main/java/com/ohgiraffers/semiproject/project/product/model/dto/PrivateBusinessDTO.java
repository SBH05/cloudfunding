package com.ohgiraffers.semiproject.project.product.model.dto;

import lombok.*;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PrivateBusinessDTO {//개인사업자
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
