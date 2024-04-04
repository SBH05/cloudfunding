package com.ohgiraffers.semiproject.delivery.model.dto;

import lombok.*;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProjectDTO {
    private int projectCode;
    private String projectTitle;
    private int projectCategoryCode;
    private String projectType;
    private int planCode;
    private int sellerInfo;
    private int targetAmount;
    private Date projectEndDate;
    private String summary;
    private String policyAgreement;
    private String sellerType;
    private String achievementStatus;
    private Date projectStartDate;
    private String progressStatus;
    private Date submissionDate;

}
