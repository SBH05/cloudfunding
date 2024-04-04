package com.ohgiraffers.semiproject.sellerManage.model.dto;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SellerManageQnADTO {

    private int creationNo;

    private int userCode;

    private String userId;

    private String title;

    private Date creation;

    private int seller;

    private String content;

    private int answerNO;

    private String answerContent;

    private Date answerDay;



}
