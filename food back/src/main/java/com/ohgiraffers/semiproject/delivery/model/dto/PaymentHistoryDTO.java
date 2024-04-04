package com.ohgiraffers.semiproject.delivery.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class PaymentHistoryDTO {

    private int paymentCode;
    private int cartCode;
}
