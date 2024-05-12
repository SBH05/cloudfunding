package com.ohgiraffers.semiproject.board.QnAcontroller;

import com.ohgiraffers.semiproject.board.model.dto.QnAPagenation;
import com.ohgiraffers.semiproject.board.model.dto.QnASelectCriteria;
import com.ohgiraffers.semiproject.board.model.service.QnAService;
import com.ohgiraffers.semiproject.common.paging.SelectCriteria;
import com.ohgiraffers.semiproject.member.model.dto.MemberAndAuthorityDTO;
import com.ohgiraffers.semiproject.order.model.dto.ProjectDTO;
import com.ohgiraffers.semiproject.sellerManage.model.dto.SellerManageQnADTO;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/QnA/*")
public class QnAController {


    private final QnAService qnAService;

    public QnAController(QnAService qnAService) {
        this.qnAService = qnAService;
    }


    @GetMapping("userwrite")
    public String userWrite(
            @ModelAttribute ProjectDTO projectDTO,
            Model model) {

        List<ProjectDTO> projectDTOList = qnAService.projectTitle();

        System.out.println("projectDTOList = " + projectDTOList);
        model.addAttribute("project",projectDTOList);

        return "content/board/userQnA/userWritePage/userQnAwrite";
    }


    @PostMapping("userwrite")
    public String userWrite(@RequestParam("title") String title,
                            @RequestParam("hiddenProjectCode") int hiddenProjectCode,
                            @RequestParam("content") String content,
                            @ModelAttribute ProjectDTO projectDTO,
                            @AuthenticationPrincipal MemberAndAuthorityDTO memberAndAuthorityDTO) {
        // 받은 데이터를 사용하여 원하는 작업 수행

        System.out.println("========== QnA controller ======= ");
        // 받은 데이터 로그에 출력
        System.out.println("Title: " + title);
        System.out.println("Hidden Project Code: " + hiddenProjectCode);
        System.out.println("Content: " + content);

        int user = memberAndAuthorityDTO.getMemberDTO().getUserCode();

        qnAService.insertQnA(user,title,content,hiddenProjectCode);

        // 필요한 작업 수행 후 사용자에게 보여줄 페이지 리턴
        return "content/board/userQnA/userWritePage/userQnAwrite";
    }





    @GetMapping("userclose")
    public String userClose(
            @RequestParam(name = "creationNo") Long creationNo,
            Model model){

        SellerManageQnADTO QnAAnswer = qnAService.QnAAnswer(creationNo);
        System.out.println("QnAAnswer = " + QnAAnswer);
        model.addAttribute("answer",QnAAnswer);


        return "content/board/userQnA/userQnAanswer/userQnAAnswerComp";

    }


    @GetMapping("userRE")
    public String userRE(){

        return "content/board/userQnA/userQnAanswer/userQnQAnswerRE";
    }




    @GetMapping("usermain")  
    public String userMain(
            Model model,
            @RequestParam(required = false) String searchValue,
            @RequestParam(value = "currentPage", defaultValue = "1") int pageNo,
            @RequestParam(required = false) String nation3,
            @AuthenticationPrincipal MemberAndAuthorityDTO memberAndAuthorityDTO){

        System.out.println("====== usermain start");

        System.out.println("검색어searchValue ================" + searchValue);


        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchValue", searchValue);

        int totalCount = qnAService.selectTotalProjectCount(searchMap);
        System.out.println("totalCount = " + totalCount);

        int limit = 3;
        int buttonAmount = 5;
        QnASelectCriteria selectCriteria = null;

        if (searchValue != null && !"".equals(searchValue)) {
            selectCriteria = QnAPagenation.QnAGetSelectCriteria
                    (pageNo, totalCount, limit, buttonAmount, nation3 ,searchValue);
        } else {
            selectCriteria = QnAPagenation.QnAGetSelectCriteria
                    (pageNo, totalCount, limit, buttonAmount);
        }

        System.out.println("selectCriteria = " + selectCriteria);

        List<SellerManageQnADTO>QnAMain = qnAService.QnAMainPage(selectCriteria);
        System.out.println("QnAMain = " + QnAMain);

        model.addAttribute("selectCriteria", selectCriteria);
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
