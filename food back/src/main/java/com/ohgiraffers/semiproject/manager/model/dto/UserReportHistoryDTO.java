package com.ohgiraffers.semiproject.manager.model.dto;

import lombok.*;

import java.sql.Date;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class UserReportHistoryDTO {

    private  int creationNumber;
    private Date creationDate;
    private int reporter;
    private String title;
    private String content;
    private int reportedPerson;
}
