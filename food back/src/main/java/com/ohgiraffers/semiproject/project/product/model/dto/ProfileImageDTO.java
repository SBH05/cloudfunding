package com.ohgiraffers.semiproject.project.product.model.dto;

import lombok.*;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProfileImageDTO {
    private int fileCode;
    private String originalFileName;
    private String path;
    private String changedProFileName;
    private char deleteStatus;
    private Date creationDate;
    private int userCode;

}
