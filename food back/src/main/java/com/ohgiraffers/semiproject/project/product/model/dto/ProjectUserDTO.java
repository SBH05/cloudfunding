package com.ohgiraffers.semiproject.project.product.model.dto;

import lombok.*;

import java.sql.Date;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ProjectUserDTO {
    private int userCode;
    private String userId;
    private String password;
    private String email;
    private Date registrationDate;
    private String address;
    private String userName;
    private Date dateBirth;
    private String phone;
    private char activityStatus;
    private int reportCount;
    private char couponStatus;
}
