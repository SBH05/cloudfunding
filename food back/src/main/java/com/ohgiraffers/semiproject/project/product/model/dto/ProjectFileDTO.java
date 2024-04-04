package com.ohgiraffers.semiproject.project.product.model.dto;

import lombok.*;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProjectFileDTO {
    private int fileCode;
    private String originalFileName;
    private String changedFileName;
    private String path;
    private Date creationDate;
    private char deleteStatus;
    private String fileType;
    private int projectCode;
}
