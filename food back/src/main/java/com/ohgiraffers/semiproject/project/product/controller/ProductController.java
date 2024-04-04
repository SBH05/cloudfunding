package com.ohgiraffers.semiproject.project.product.controller;

import com.ohgiraffers.semiproject.common.exception.project.ProductReviewException;
import com.ohgiraffers.semiproject.common.exception.project.StoryRegistException;
import com.ohgiraffers.semiproject.member.model.dto.MemberAndAuthorityDTO;
import com.ohgiraffers.semiproject.project.product.model.dto.*;
import com.ohgiraffers.semiproject.project.product.model.service.ProductService;
import com.ohgiraffers.semiproject.project.product.model.service.ProductServiceimpl;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.List;


@Controller
@RequestMapping("product")
@Slf4j
public class ProductController {

    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

//    @GetMapping("productStory")
//    public



    @GetMapping("productStory")
    public ModelAndView productStory(ModelAndView mv,
                                     @RequestParam Long no
                                                                )  {

        log.info("");
        log.info("");
        log.info("[ThumbnailController] ========================================================= start");

        TotalStoryDTO thumbnailList = productService.totalStoryList(no);
        ProfileImageDTO profileImage = productService.profileimage(no);

        List<ProjectOptionDTO> projectOption = productService.optionList(no);
        List<ProjectFileDTO> projectFile = productService.projectimage(no);





        log.info("[ThumbnailController] thumbnailList : " + thumbnailList);
        mv.addObject("thumbnailList", thumbnailList);
        mv.addObject("profileImage",profileImage);

        mv.addObject("projectOption", projectOption);
        mv.addObject("projectFile",projectFile);
        log.info("[ThumbnailController] ========================================================= end");

        mv.setViewName("content/project/product/productStory");

        log.info("[ThumbnailController] ========================================================= end");

        return mv;
    }



    @GetMapping("productPage")
    public ModelAndView productPage(ModelAndView mv,
                                         @RequestParam Long no
                                            ){
        log.info("");
        log.info("");
        log.info("[ThumbnailController] ========================================================= start");

        TotalStoryDTO thumbnailList = productService.totalStoryList(no);
        ProfileImageDTO profileImage = productService.profileimage(no);

        List<ProjectOptionDTO> projectOption = productService.optionList(no);
        List<ProjectFileDTO> projectFile = productService.projectimage(no);

//        ProductReviewDTO productreview =

//        int userCode = memberAndAuthorityDTO.getMemberDTO().getUserCode();
//        System.out.println(userCode);


        List<MemberAndReviewDTO> memberAndReviewDTO = productService.selectReview(no);

        System.out.println("memberAndReviewDTO============================================= = " + memberAndReviewDTO);

        mv.addObject("memberAndReviewDTO", memberAndReviewDTO);
        mv.addObject("thumbnailList", thumbnailList);
        mv.addObject("profileImage",profileImage);

        mv.addObject("projectOption", projectOption);
        mv.addObject("projectFile",projectFile);
        log.info("[ThumbnailController] ========================================================= end");

        log.info("[ThumbnailController] thumbnailList : " + thumbnailList);
        mv.setViewName("content/project/product/productPage");

        log.info("[ThumbnailController] ========================================================= end");

        return mv;
    }
    @PostMapping("productPage")
    public String productReview(@AuthenticationPrincipal MemberAndAuthorityDTO memberAndAuthorityDTO,
                                @RequestParam int projectCode,
                                @RequestParam("reviewContent") String productContent, // 후기 내용을 받아오는 부분
                                Model model

    )throws ProductReviewException
    {
        System.out.println(productContent + "================================productContent");
        // 유저의 프로필 이미지 정보를 가져오는 로직
        int userCode = memberAndAuthorityDTO.getMemberDTO().getUserCode();


        ProfileImageDTO userProfileImage = productService.getProfileImage(userCode);
        String changedProFileName = userProfileImage.getChangedProFileName();
        ProductReviewDTO review = new ProductReviewDTO();
        review.setUserCode(memberAndAuthorityDTO.getMemberDTO().getUserCode()); //ProductReviewDTO에 userCode 설정
        review.setProjectCode(projectCode);
//         안녕,안녕 이 기준일 때 "," 기준으로 안녕,안녕 을 나눈다 안녕[0],안녕[1]
//         db에 후기를 입력하면 자꾸 ,이 앞에 붙어서 저장되길래 스크립트는 수정하기 어려워서 임시조치함
                String[] addressParts = productContent.split(",");
//                String productContent1 = addressParts[0];
                String productContent2 = addressParts[1];
        review.setReviewContent(productContent2); //후기내용 requestparam으로 받은거 ProductReviewDTO에 넣는 작업


        review.setProfileImage(changedProFileName);


        productService.addReview(review);



        return "redirect:/product/productPage?no=" + projectCode; // 적절한 리디렉션 주소로 수정
    }

    @GetMapping("productQnA")
    public String productQnA(){

        return "/content/project/product/productQnA";
    }
}