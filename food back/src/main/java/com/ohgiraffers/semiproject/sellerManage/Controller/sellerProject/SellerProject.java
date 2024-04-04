package com.ohgiraffers.semiproject.sellerManage.Controller.sellerProject;

import com.ohgiraffers.semiproject.common.paging.Pagenation;
import com.ohgiraffers.semiproject.common.paging.SelectCriteria;
import com.ohgiraffers.semiproject.member.model.dto.MemberAndAuthorityDTO;
import com.ohgiraffers.semiproject.sellerManage.model.dto.SellerManageProjectDTO;
import com.ohgiraffers.semiproject.sellerManage.model.service.SellerProjectService;
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


@Controller
@Slf4j
@RequestMapping("/sellerManage/*")
public class SellerProject {

    private final SellerProjectService sellerProjectService;

    public SellerProject(SellerProjectService sellerProjectService) {
        this.sellerProjectService = sellerProjectService;
    }

    @GetMapping("Project")
    public ModelAndView sellerProjectLocation(
            ModelAndView mv,
            Principal principal) {

        log.info("[SellerManageProjectController] sellerProject ================================== start");


        String userId = principal.getName();
        log.info("[SellerManageProjectController] sellerProject  ================================== {} ", userId);

        List<SellerManageProjectDTO> sellerProject = sellerProjectService.sellerProject(userId);

        mv.addObject("Project", sellerProject);
        mv.setViewName("content/sellerManage/sellerProject/sellerProjectSearch");

        return mv;
    }



    @GetMapping("ProjectDetail")
    public String sellerDetailLocation(
            Model model,
            @AuthenticationPrincipal MemberAndAuthorityDTO memberAndAuthorityDTO){
        log.info("[SellerManageProjectDetailController] ProjectDetail ================================== start");
        log.info("[SellerManageProjectDetailController] ProjectDetail  ================================== {} ", memberAndAuthorityDTO);

        SellerManageProjectDTO sellerProjectDetail = sellerProjectService.sellerProjectDetail();
        model.addAttribute("projectDetail",sellerProjectDetail);

        return "content/sellerManage/sellerProject/sellerProjectDetail";
    }

}
