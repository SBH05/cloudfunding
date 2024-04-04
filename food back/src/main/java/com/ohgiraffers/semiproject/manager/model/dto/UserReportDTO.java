package com.ohgiraffers.semiproject.manager.model.dto;

import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class UserReportDTO {
    private Date creationDate;
    private String title;
    private UserReportAnswerDTO creationNumber;
    private String content;
    private UserDTO reporter;
    private UserDTO1 reportedPerson;
}

