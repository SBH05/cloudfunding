package com.ohgiraffers.semiproject.manager.model.dto;

import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class InquiryAnswerDTO {

    int answerCode;
    String answerContent;
    int creationNumber;
    Date answerDate;
}
