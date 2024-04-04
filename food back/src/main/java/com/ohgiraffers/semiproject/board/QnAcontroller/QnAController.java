package com.ohgiraffers.semiproject.board.QnAcontroller;


import com.ohgiraffers.semiproject.board.model.dto.QnAhistoryDTO;
import com.ohgiraffers.semiproject.board.model.service.QnAService;
import com.ohgiraffers.semiproject.common.notice.QnARegistException;
import com.ohgiraffers.semiproject.member.model.dto.MemberAndAuthorityDTO;
import com.ohgiraffers.semiproject.order.model.dto.ProjectDTO;
import com.ohgiraffers.semiproject.sellerManage.model.dto.SellerManageProjectDTO;
import com.ohgiraffers.semiproject.sellerManage.model.dto.SellerManageQnADTO;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/QnA/*")
public class QnAController {


    private final QnAService qnAService;

    public QnAController(QnAService qnAService) {
        this.qnAService = qnAService;
    }


    @GetMapping("userwrite")
    public String userWrite(){

        return "content/board/userQnA/userWritePage/userQnAwrite";
    }

    @PostMapping("userwrite")
    public String userRegist(
            @ModelAttribute QnAhistoryDTO qnAhistory,
            @AuthenticationPrincipal MemberAndAuthorityDTO memberAndAuthorityDTO,
            Model model,
            RedirectAttributes rttr) throws QnARegistException {

        System.out.println("==============================================start");
        System.out.println("qnAhistory =================================== " + qnAhistory);
        System.out.println("memberAndAuthorityDTO ============================= " + memberAndAuthorityDTO);

        qnAService.registQnA(qnAhistory);

        int seller = qnAhistory.getSellerCode();
        System.out.println("seller =========================== " + seller);


        List<SellerManageProjectDTO> projectInfo = qnAService.projectinformation();
        model.addAttribute("projectInfo",projectInfo);



        rttr.addFlashAttribute("message", "QnA 등록에 성공하셨습니다!");
        System.out.println("[BoardController] qnARegist ========================================================= end");

        return "redirect:content/board/userQnA/userWritePage/userQnAwrite";
    }



    @GetMapping("userclose")
    public String userClose(
            @RequestParam(name = "creationNo") Long creationNo,
            Model model,
            @AuthenticationPrincipal MemberAndAuthorityDTO memberAndAuthorityDTO){

        System.out.println("============================================QnAcontroller userclose start");
        System.out.println("============================================" +memberAndAuthorityDTO );
        System.out.println("============================================" + creationNo );

        String userId = memberAndAuthorityDTO.getUsername();
        System.out.println("userId = =============================================" + userId);

        SellerManageQnADTO QnAClose = qnAService.QnAClosePage(creationNo);
        model.addAttribute("Close",QnAClose);


        int sellerCode = QnAClose.getSeller();
        int uerCode = QnAClose.getUserCode();

        if(sellerCode == uerCode) {
            String sellerId =QnAClose.getUserId();
            System.out.println("sellerId = " + sellerId);
        }



        System.out.println("QnAClose = " + QnAClose);
        return "content/board/userQnA/userQnAanswer/userQnAAnswerComp";


    }


    @GetMapping("userRE")
    public String userRE(){

        return "content/board/userQnA/userQnAanswer/userQnQAnswerRE";
    }




    @GetMapping("usermain")  
    public String userMain(
            Model model,
            @AuthenticationPrincipal MemberAndAuthorityDTO memberAndAuthorityDTO){

        System.out.println("============================================QnAcontroller usermain start");
        System.out.println("============================================QnAcontroller usermain start" +memberAndAuthorityDTO );

        String userId = memberAndAuthorityDTO.getUsername();
        System.out.println("userId = =============================================" + userId);
        List<SellerManageQnADTO>QnAMain = qnAService.QnAMainPage(userId);
        System.out.println("QnAMain = " + QnAMain);

        model.addAttribute("QnAMainPage",QnAMain);


        return "content/board/userQnA/userMainPage/userQnAmainpage";
    }



    @GetMapping("sellermain")
    public String sellerMain(){

        return "content/board/sellerQnA/sellerMainPage/sellerQnAmainpage";
    }


    @GetMapping("sellerclose")
    public String sellerClose(){

        return "content/board/sellerQnA/sellerQnAanswer/sellerQnAAnswerClose";
    }


    @GetMapping("sellerRE")
    public String sellerRE(){

        return "content/board/sellerQnA/sellerQnAanswer/sellerQnAnswerRE";
    }


    @GetMapping("sellerwrite")
    public String sellerWrite(){

        return "content/board/sellerQnA/sellerWritePage/sellerQnAwrite";
    }



}
