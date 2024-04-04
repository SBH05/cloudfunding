package com.ohgiraffers.semiproject.delivery.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProjectOptionDTO {
    private int optionCode;
    private String optionName;
    private String optionType;
    private int price;
    private String configure;
    private int projectCode;
}
