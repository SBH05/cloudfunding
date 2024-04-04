package com.ohgiraffers.semiproject.project.product.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class ProductReviewDTO {
    private int contentNumber;
    private int userCode;
    private String profileImage;
    private String reviewContent;
    private int projectCode;
}
