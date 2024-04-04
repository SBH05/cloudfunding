package com.ohgiraffers.semiproject.manager.model.dto;

import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class UserDTO1 {

    private int code;
    private String id;
    private String pass;
    private String em;
    private Date RD;
    private String ad;
    private String name;
    private String birth;
    private String ph;
    private char AS;
    private int count;
    private char coupon;

}
