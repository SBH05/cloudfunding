package com.ohgiraffers.semiproject.order.model.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProjectOptionDTO {

    private int code;

    private String name;

    private String type;

    private int price;

    private String config;

    private ProjectDTO projectCode;


}
