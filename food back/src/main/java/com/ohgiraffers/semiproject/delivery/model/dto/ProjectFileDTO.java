package com.ohgiraffers.semiproject.delivery.model.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProjectFileDTO {
    private int fileCode;
    private String originalFileName;
    private String changedFileName;
    private String path;
    private Date creationDate;
    private String deleteStatus;
    private String fileType;
    private int projectCode;
}
