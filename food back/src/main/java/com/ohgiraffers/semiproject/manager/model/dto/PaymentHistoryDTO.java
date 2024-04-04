package com.ohgiraffers.semiproject.manager.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class PaymentHistoryDTO {
    private int paymentCode;
    private CartDTO cartCode; // 사용자 정보, 프로젝트 정보를 보기 위함
}
