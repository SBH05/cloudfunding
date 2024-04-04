package com.ohgiraffers.semiproject.manager.model.dto;

import lombok.*;

import java.sql.Date;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class PaymentDTO {

    private int paymentCode;
    private int totalAmount;
    private String paymentMethod;
    private Date paymentDateTime;
    private int deliveryCode;
    private char paymentStatus;

}
