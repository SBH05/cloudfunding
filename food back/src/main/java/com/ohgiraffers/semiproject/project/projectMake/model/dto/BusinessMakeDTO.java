package com.ohgiraffers.semiproject.project.projectMake.model.dto;

import lombok.*;

import java.sql.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BusinessMakeDTO {

    int sellCode;
    String busiName;
    String indu;
    Date estaDate;
    String home;
    String loca;
    String busiPhone;
    String busiLicenseNumber;
    String busiEmail;
}
