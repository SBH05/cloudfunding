package com.ohgiraffers.semiproject.sellerManage.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class SellerUserMangeDTO {

    private int userCode;

    private int projectCode;

    private int paymentCode;

    private int cartCode;

    private String projectTitle;

    private String option;

    private String userName;

    private String phone;

    private String address;

    private String returnHistory;

    private Date delivery;

    private String deliveryStatus;

}
