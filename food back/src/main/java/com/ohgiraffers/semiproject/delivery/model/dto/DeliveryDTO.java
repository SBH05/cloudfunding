package com.ohgiraffers.semiproject.delivery.model.dto;

import lombok.*;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DeliveryDTO {
    private int deliveryCode;
    private Date deliveryDate;
    private String deliveryStatus;
    private int userCode;
    private String deliveryRequest;
    private String purchaseConfirm;
    private Date purchaseConfirmDate;

}
