package com.ohgiraffers.semiproject.manager.model.dto;

import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ApprovalHistoryDTO {

    private int approvalCode;
    private Date approvalDate;
    private String declineReason;
    private String approvalStatus;
    private int projectCode;
}
