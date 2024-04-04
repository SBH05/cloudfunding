package com.ohgiraffers.semiproject.order.model.dto;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor

public class CartInsertDTO {

    private int cartCode;

    private int userCode;

    private String userId;

    private String projectTitle;

    private String optionName;

    private int price;

    private String configure;

    private String optionType;

    private int amount;

    private String coupon;

    private Date end;

    private Date start;

    private int projectCode;

    private int projectCode1;

    private String changeName;




}