package com.ohgiraffers.semiproject.order.model.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaymentHistoryDTO {

    private PaymentDTO payment;


    private CartDTO cart;

    private String changeName ;





}
