package com.ohgiraffers.semiproject.delivery.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CartDTO {
    private int cartCode;
    private int userCode;
    private int projectCode;
    private int optionCode;
    private String usageStatus;
    private int cartCount;
}
