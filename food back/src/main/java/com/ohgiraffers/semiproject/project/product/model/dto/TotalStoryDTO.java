package com.ohgiraffers.semiproject.project.product.model.dto;

import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TotalStoryDTO {
    private ProjectDTO projectDTO;
    private List<ProjectFileDTO> projectFileDTO;
    private ProjectOptionDTO projectOptionDTO;
    private PrivateBusinessDTO privateBusinessDTO;
    private List<ProfileImageDTO> profileImageDTO;
    private ProjectUserDTO projectUserDTO;



}
