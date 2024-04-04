package com.ohgiraffers.semiproject.manager.model.dto;

import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class UserReportAnswerDTO {
    private int answerCode;
    private String answerContent;
    private int creationNumber;
    private Date answerDate;
    private String actionDetail;
}
