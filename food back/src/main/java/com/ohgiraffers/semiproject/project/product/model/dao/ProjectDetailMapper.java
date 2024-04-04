package com.ohgiraffers.semiproject.project.product.model.dao;

import com.ohgiraffers.semiproject.project.product.model.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProjectDetailMapper {
    TotalStoryDTO totalStoryList(Long no);
    List<ProjectOptionDTO> optionList(Long no);

    List<ProjectFileDTO> projectimage(Long no);

    ProfileImageDTO profileimage(Long no);

    int addReview(ProductReviewDTO review);

    ProfileImageDTO getProfileImage(int userCode);

    List<MemberAndReviewDTO> selectReview(long no);

//    int addReview(Map<String, Object> productReview);
}
//