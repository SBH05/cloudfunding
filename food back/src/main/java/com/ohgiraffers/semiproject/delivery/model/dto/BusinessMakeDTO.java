package com.ohgiraffers.semiproject.delivery.model.dto;

import lombok.*;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class BusinessMakeDTO {
    private int sellCode;
    private String busiName;
    private String indu;
    private Date estaDate;
    private String home;
    private String loca;
    private String busiPhone;
    private String busiLicenseNumber;
    private String busiEmail;
}
