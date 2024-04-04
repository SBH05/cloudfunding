package com.ohgiraffers.semiproject.project.product.model.dto;

import com.ohgiraffers.semiproject.member.model.dto.MemberDTO;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberAndReviewDTO {
    private MemberDTO memberDTO;
    private ProductReviewDTO productReviewDTO;

}
