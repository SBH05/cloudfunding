package com.ohgiraffers.semiproject.project.product.model.dto;

import com.ohgiraffers.semiproject.manager.model.dto.UserDTO;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProjectDTO {//프로젝트

    private int projectCode;
    private String projectTitle;
    private int projectCategory;
    private String projectType;
    private int plan;
    private int sellerInfo;
    private int targetAmount;
    private Date projectEndDate;
    private String projectSummary;
    private char policyAgreement;
    private String sellerType;
    private char achievementStatus;
    private Date projectStartDate;
    private String progressStatus;
}

