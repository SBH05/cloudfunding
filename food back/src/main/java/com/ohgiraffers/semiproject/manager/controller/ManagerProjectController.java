package com.ohgiraffers.semiproject.manager.controller;

import com.ohgiraffers.semiproject.common.notice.NoticeRegistException;
import com.ohgiraffers.semiproject.common.paging.Pagenation;
import com.ohgiraffers.semiproject.common.paging.SelectCriteria;
import com.ohgiraffers.semiproject.manager.model.dto.*;
import com.ohgiraffers.semiproject.manager.model.service.ManageProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@Slf4j
@RequestMapping("/manager/project")
public class ManagerProjectController {

    private final ManageProjectService manageProjectService;

    public ManagerProjectController(ManageProjectService manageProjectService) {
        this.manageProjectService = manageProjectService;
    }
//

//    @GetMapping("/declineDetail")
//    public String declineDetail(){return "content/manager/project/declineDetail";}
//    @GetMapping("/declineMain")
//    public String declineMain(){return "content/manager/project/declineMain";}



    @GetMapping("/approve")
    public String approve(@RequestParam Long no,
                          RedirectAttributes rttr) throws NoticeRegistException{

        manageProjectService.approve(no);

        rttr.addFlashAttribute("message", "승인에 성공했습니다");

        return "redirect:/manager/project/newMain";



    }

    @GetMapping("/declineDetail")
    public String declineDetail(@RequestParam Long no, Model mv) {


        ProjectDTO projectDTO = manageProjectService.findOneProject(no);
        String status = manageProjectService.findStatus(no);

        mv.addAttribute("project",projectDTO);
        mv.addAttribute("status", status);




        return "/content/manager/project/declineReason";
    }

    @PostMapping("/declineDetail")
    public String declineReason(@ModelAttribute ApprovalHistoryDTO approvalHistoryDTO,
                                RedirectAttributes rttr) throws NoticeRegistException{


        System.out.println("approvalHistoryDTO ========================== " + approvalHistoryDTO);

        manageProjectService.declineReason(approvalHistoryDTO);
        rttr.addFlashAttribute("message", "등록에 성공했습니다");

        return "redirect:/manager/project/newMain";
    }
    @GetMapping("/newDetail")
    public String newDetail(@RequestParam Long no, Model mv){

            log.info("controller projectDetail start===========================");

        ProjectDTO projectDTO = manageProjectService.findOneProject(no);
        String status = manageProjectService.findStatus(no);

        mv.addAttribute("project",projectDTO);
        mv.addAttribute("status", status);
            log.info("controller projectDetail end ===============================");

            return "content/manager/project/newDetail";
        }

    @GetMapping("/newMain")
    public ModelAndView newMain(@RequestParam(required = false, defaultValue = "code") String nation1, // 정렬 컬럼 선택
                          @RequestParam(required = false, defaultValue = "desc") String nation2, // 정렬 방식 선택
                          @RequestParam(required = false) String nation3, //검색할 컬럼 선택
                          @RequestParam(required = false, defaultValue = "all") String authority, // 전체, 사용자, 판매자, 신고자 선택
                          @RequestParam(required = false) String searchValue, // 검색어 입력하는곳 받기
                          @RequestParam(value = "currentPage", defaultValue = "1") int pageNo, // 보여질 페이지 넘버, 기본이 1


                          ModelAndView mv) {

        System.out.println("nation 1 ===============" + nation1);
        System.out.println("nation 2 ===============" + nation2);
        System.out.println("nation 3 ===============" + nation3);
        System.out.println("authority ============== " + authority);
        System.out.println("검색어searchValue ================" + searchValue);


        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("nation1", nation1); // 정렬 컬럼
        searchMap.put("nation2", nation2); //  정렬 방식
        searchMap.put("authority", authority); // 신규 리펀딩 신고 반려
        searchMap.put("nation3", nation3); // 검색설정
        searchMap.put("searchValue", searchValue); // 검색어
        // 키와 밸류로 찾을 값 넣어주기



        int totalCount = manageProjectService.selectTotalCount(searchMap);
        // 전체 게시물 수?

        /* 한 페이지에 보여 줄 게시물 수 */
        int limit = 3;        //얘도 파라미터로 전달받아도 된다.

        /* 한 번에 보여질 페이징 버튼의 갯수 */
        int buttonAmount = 5;

        SelectCriteria selectCriteria = null;

        if (nation3 != null && !"".equals(nation3)) {
            // 선택지가 null 이 아니고 공백이 아니라면
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, nation1, nation2, authority, nation3, searchValue);
            // 선택지도 있는 생성자에 넣어라
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, nation1, nation2, authority);
            // 아니면 선택지가 없는 생성자에 넣어라
        }

        System.out.println("selectCriteria = " + selectCriteria);

        List<ProjectDTO> project = manageProjectService.findAllProject(selectCriteria);


        mv.addObject("selectCriteria", selectCriteria);
//        페이징 처리에 대한 정보가 담겨있는 DTO를 넘겨 쿼리문에서 사용하기 위함
        mv.addObject("projectlist", project);
        mv.setViewName("/content/manager/project/newMain");

        return mv;
    }

//
//    @GetMapping("/reDetail")
//    public String reDetail(){return "content/manager/project/reDetail";}
//    @GetMapping("/reMain")
//    public String reMain(){return "content/manager/project/reMain";}



}

