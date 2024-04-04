package com.ohgiraffers.semiproject.sellerManage.Controller.sellerQnAmanage;

import com.ohgiraffers.semiproject.common.paging.Pagenation;
import com.ohgiraffers.semiproject.common.paging.SelectCriteria;
import com.ohgiraffers.semiproject.member.model.dto.MemberAndAuthorityDTO;
import com.ohgiraffers.semiproject.sellerManage.model.dto.SellerManageQnADTO;
import com.ohgiraffers.semiproject.sellerManage.model.service.SellerQnAmangeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/sellerManage/*")
public class SellerQnAController {


    private final SellerQnAmangeService sellerQnAmangeService;

    public SellerQnAController(SellerQnAmangeService sellerQnAmangeService) {
        this.sellerQnAmangeService = sellerQnAmangeService;
    }

    @GetMapping("/QnACom")
    public String getQnALocation(){
        return "/content/sellerManage/sellerQnAmanage/sellerQnAAnswerComp";
    }




    @GetMapping("/QnAing")
    public String sellerProjectQnAWritingLocation(){
        return "content/sellerManage/sellerQnAmanage/sellerQnAAnswering";
    }



    @GetMapping("/QnAmanage")
    public ModelAndView sellerQnAmange(
            ModelAndView mv,
            @AuthenticationPrincipal MemberAndAuthorityDTO memberAndAuthorityDTO) {


        log.info("[SellerQnAmanageController] QnAmanage ================================== start");
        log.info("[SellerQnAmanageController] QnAmanage  ================================== {} ", memberAndAuthorityDTO);

        int userCode = memberAndAuthorityDTO.getUserCode();

        List<SellerManageQnADTO> sellerManageQnA = sellerQnAmangeService.sellerQnA(userCode);
        mv.addObject("manageQnA",sellerManageQnA);

        mv.setViewName("content/sellerManage/sellerQnAmanage/sellerQnAmanage");


        return mv;
    }


}

