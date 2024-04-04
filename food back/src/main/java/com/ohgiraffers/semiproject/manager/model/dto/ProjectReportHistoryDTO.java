package com.ohgiraffers.semiproject.manager.model.dto;

import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProjectReportHistoryDTO {

    private int projectReportCode;
    private UserDTO1 reporter;
    private ProjectDTO reportProject;
    private Date reportDate;
    private String reportType;
    private String reportReason;
    private String actionDetail;

}
