package com.ohgiraffers.semiproject.member.model.dto;

import lombok.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProfileImgDTO {
    private Integer fileCode;
    private String originalFileName;
    private String path;
    private String changedproFileName;
    private String deleteStatus;
    private Date creationDate;
    private int userCode;
}
