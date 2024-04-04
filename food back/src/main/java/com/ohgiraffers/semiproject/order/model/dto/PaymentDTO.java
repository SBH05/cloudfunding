package com.ohgiraffers.semiproject.order.model.dto;


import lombok.*;

import java.sql.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PaymentDTO {

    private int code;

    private int amount;

    private String method;

    private Date time;



    private String status;





}
