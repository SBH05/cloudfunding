package com.ohgiraffers.semiproject.order.model.dto;

import lombok.*;

import java.sql.Date;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class ProjectFileDTO {

    private int fileCode;
    private String originName;
    private String changeName;
    private String path;
    private Date creationDate;
    private String deleteStatus;
    private String fileType;
    private ProjectDTO projectDTO;
}
