package com.ohgiraffers.semiproject.manager.model.dto;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class NoticeDTO {

    private int creationNumber;
    private Date creationDate;
    private String title;
    private String content;
    private char deleteStatus;
    private int userCode;
}
