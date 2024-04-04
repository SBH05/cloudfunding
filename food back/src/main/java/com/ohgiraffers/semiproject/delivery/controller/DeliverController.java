package com.ohgiraffers.semiproject.delivery.controller;


import com.ohgiraffers.semiproject.delivery.model.dto.TotalDeliveryDTO;
import com.ohgiraffers.semiproject.delivery.model.dto.TotalDeliveryDTO2;
import com.ohgiraffers.semiproject.delivery.model.service.DeliveryService;

import com.ohgiraffers.semiproject.member.model.dto.MemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/deliver")
@Slf4j
public class DeliverController {
    private final DeliveryService deliveryService;

    public DeliverController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping("/userdetail")
    public String userdetail(@RequestParam("projectTitle") String projectTitle,
                             @RequestParam("projectCode") int projectCode,
                             @RequestParam("changedFileName") String changedFileName,
                             @RequestParam("deliveryCode") int deliveryCode,
                             Principal principal,
                             Model model){
        String userId = principal.getName();
        MemberDTO memberDTO = deliveryService.searchUserCodeByUserId(userId);
        int userCode = memberDTO.getUserCode();
        List<TotalDeliveryDTO2> totalDeliveryDTO2 = deliveryService.searchDeliveryStatus1(userCode, projectTitle, projectCode,changedFileName,deliveryCode);

        System.out.println("totalDeliveryDTO2======================================" + totalDeliveryDTO2);
        model.addAttribute("totalDeliveryDTO2", totalDeliveryDTO2);
        System.out.println("totalDeliveryDTO2 ======================================================== " + totalDeliveryDTO2);


        return "content/deliver/userDeliver/userDeliverDetailPage/userDeliverDetail";
    }



    @GetMapping("/usermain")
    public String usermain(Principal principal, Model model){
        String userId = principal.getName();
        MemberDTO memberDTO = deliveryService.searchUserCodeByUserId(userId);
        int userCode = memberDTO.getUserCode();
        System.out.println("===========================userCode" + userCode);

        List<TotalDeliveryDTO> totalDeliveryDTO = deliveryService.searchDeliveryStatus(userCode);
        System.out.println("totalDeliveryDTO======================================" + totalDeliveryDTO);
        model.addAttribute("totalDeliveryDTO", totalDeliveryDTO);
        System.out.println("totalDeliveryDTO ======================================================== " + totalDeliveryDTO);





        return "content/deliver/userDeliver/userMainPage/userDeliverMainPage";
    }


    @GetMapping("/sellerdetail")
    public String sellerdetail(){
        return "content/deliver/sellerDeliver/sellerDeliverDetailPage/sellerDeliverDtail";
    }


    @GetMapping("/sellermain")
    public String sellermain(){
        return "content/deliver/sellerDeliver/sellerMainPage/sellerDeliverMainPage";
    }

}
