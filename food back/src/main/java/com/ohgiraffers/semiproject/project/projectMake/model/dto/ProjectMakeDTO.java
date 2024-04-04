package com.ohgiraffers.semiproject.project.projectMake.model.dto;

import lombok.*;
import org.springframework.stereotype.Service;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProjectMakeDTO {

    private String title;
    private String category;
    private String type;
    private String plan;
    private String targetAmount;
    private Date endDate;
    private Date startDate;
    private String summary;
    private String sellerType;
    private int sellerCode;
    private String tag;

}
