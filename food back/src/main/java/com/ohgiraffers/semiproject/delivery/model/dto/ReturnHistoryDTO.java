package com.ohgiraffers.semiproject.delivery.model.dto;

import lombok.*;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ReturnHistoryDTO {
    private int paymentCode;
    private Date applicationDate;
    private String returnReason;
    private String processingStatus;
    private Date completionDate;
}
