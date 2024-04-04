package com.ohgiraffers.semiproject.project.model.dto;


import lombok.*;

import java.sql.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProjectDTO {


    private int code;

    private String title;

    private ProjectCategoryDTO category;

    private String type;

    private PlanDTO plan;

    private SellerInfoDTO seller;

    private int amount;

    private Date end;

    private String summary;

    private String agree;

    private String sellerType;

    private String status;

    private Date start;

    private String progress;



}
