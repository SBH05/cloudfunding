package com.ohgiraffers.semiproject.manager.model.dto;

import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class InquiryDTO {

    private InquiryAnswerDTO creationNumber;
    private UserDTO userCode;
    private String title;
    private String content;
    private Date creationDate;
}
