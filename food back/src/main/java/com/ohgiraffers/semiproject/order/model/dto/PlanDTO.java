package com.ohgiraffers.semiproject.order.model.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PlanDTO {

    private int code;

    private String name;

    private int price;

    private String detail;


}
