package com.ohgiraffers.semiproject.order.model.dto;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CancelHistoryDTO {

    private PaymentDTO paymentCode;

    private Date application;

    private String reason;

    private String status;

    private Date completion;


}
