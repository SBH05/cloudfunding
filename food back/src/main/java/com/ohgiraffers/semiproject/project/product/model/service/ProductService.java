package com.ohgiraffers.semiproject.project.product.model.service;

import com.ohgiraffers.semiproject.project.product.model.dto.*;

import java.util.List;

public interface ProductService {
    TotalStoryDTO totalStoryList(Long no);

    List<ProjectOptionDTO> optionList(Long no);

    List<ProjectFileDTO> projectimage(Long no);

    ProfileImageDTO profileimage(Long no);

    void addReview(ProductReviewDTO review);

    ProfileImageDTO getProfileImage(int userCode);

    List<MemberAndReviewDTO> selectReview(Long no);

//    void addReview(Map<String, Object> productReview);

//    static List<ProDTO> selectAllproductStoryList() { 왜 스테틱?
}
