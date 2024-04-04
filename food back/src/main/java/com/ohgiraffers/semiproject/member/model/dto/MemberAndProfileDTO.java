package com.ohgiraffers.semiproject.member.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberAndProfileDTO {
    private MemberDTO memberDTO;
    private ProfileImgDTO profileImgDTO;
}
