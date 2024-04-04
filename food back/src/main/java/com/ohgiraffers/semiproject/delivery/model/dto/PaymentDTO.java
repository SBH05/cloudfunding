package com.ohgiraffers.semiproject.delivery.model.dto;

import lombok.*;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class PaymentDTO {
    private int paymentCode;
    private int totalAmount;
    private String paymentMethod;
    private Date paymentDateTime;
    private int deliveryCode;
    private String paymentStatus;
}
