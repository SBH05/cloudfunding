package com.ohgiraffers.semiproject.project.projectMake.model.dto;

import lombok.*;

import java.sql.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProjectMakeFileDTO {

    String originFileName;
    int fCode;
    int sCode;
    String changeFileName;
    String filePath;
    Date createDate;
    String type;
}
