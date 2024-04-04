package com.ohgiraffers.semiproject.order.model.dto;


import lombok.*;

import java.sql.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO {

    private int userCode;

    private String name;

    private String email;

    private String address;

    private String phone;

    private String projectTitle;

    private String optionName;

    private int price;

    private String configure;

    private String optionType;

    private int amount;

    private String coupon;

    private int deliverCode;

    private Date deliveryDate;

    private String paymentStatus;

    private int cartNumber;

    private int count;

    private int projectCode;


    private String changeName;

}
