package com.ohgiraffers.semiproject.main.model.dto;

import com.ohgiraffers.semiproject.manager.model.dto.UserDTO;
import com.ohgiraffers.semiproject.project.product.model.dto.ProjectFileDTO;
import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ProjectDTO {

    private int projectCode;
    private String projectTitle;
    private int projectCategory;
    private String projectType;
    private int projectPlan;
    private int sellerInfo;
    private int targetAmount;
    private Date projectEndDate;
    private String projectSummary;
    private char policyAgreement;
    private String sellerType;
    private char achievementStatus;
    private Date projectStartDate;
    private String progressStatus;
    private Date submissionDate;
    private String changedFileName;
}
