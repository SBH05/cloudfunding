package com.ohgiraffers.semiproject.manager.model.dto;

import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class UserDTO {

    private int userCode;
    private String userId;
    private String password;
    private String email;
    private Date registrationDate;
    private String address;
    private String userName;
    private String dateBirth;
    private String phone;
    private char activityStatus;
    private int reportCount;
    private char couponStatus;
    private int authorityCode;

}
