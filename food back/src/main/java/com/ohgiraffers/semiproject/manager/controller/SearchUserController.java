package com.ohgiraffers.semiproject.manager.controller;

import com.ohgiraffers.semiproject.common.exception.member.MemberRemoveException;
import com.ohgiraffers.semiproject.common.notice.NoticeModifyException;
import com.ohgiraffers.semiproject.common.notice.NoticeRemoveException;
import com.ohgiraffers.semiproject.common.paging.Pagenation;
import com.ohgiraffers.semiproject.common.paging.SelectCriteria;
import com.ohgiraffers.semiproject.common.util.SessionUtil;
import com.ohgiraffers.semiproject.manager.model.dto.*;
import com.ohgiraffers.semiproject.manager.model.service.SearchUserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
@RequestMapping("/manager/search")
public class SearchUserController {
    private final SearchUserService searchUserService;

    public SearchUserController(SearchUserService searchUserService) {
        this.searchUserService = searchUserService;
    }

    @GetMapping("/userDetail")
    public String userDetail(@RequestParam Long no, Model mv) {


        log.info("controller userDetail start===========================");

        List<CartDTO> cartDTOS = searchUserService.userBuy(no);
        List<UserReportHistoryDTO> userReportHistoryDTOS = searchUserService.userReport(no);
        List<ProjectDTO> projectDTOS = searchUserService.userFundingProject(no);
        UserDTO userDTOS = searchUserService.findOneUser(no);
        PrivateBusinessDTO privateBusinessDTO = searchUserService.companyInfo(no);

        mv.addAttribute("userInfo", userDTOS);
        mv.addAttribute("companyInfo", privateBusinessDTO);
        mv.addAttribute("userBuy", cartDTOS);
        mv.addAttribute("userReport", userReportHistoryDTOS);
        mv.addAttribute("userFunding", projectDTOS);


        log.info("controller userDetail end ===============================");

        return "/content/manager/search/userDetail";
    }

    @GetMapping("/userMain")
    public ModelAndView userMain(
            @RequestParam(required = false, defaultValue = "name") String nation1, // 정렬 컬럼 선택
            @RequestParam(required = false, defaultValue = "asc") String nation2, // 정렬 방식 선택
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
        searchMap.put("nation1", nation1);
        searchMap.put("nation2", nation2);
        searchMap.put("nation3", nation3);
        searchMap.put("authority", authority);
        searchMap.put("searchValue", searchValue);
        // 키와 밸류로 찾을 값 넣어주기

        int totalCount = searchUserService.selectTotalCount(searchMap);
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


        List<UserDTO> userDTOS = searchUserService.findAllUser(selectCriteria);


        mv.addObject("selectCriteria", selectCriteria);
//        페이징 처리에 대한 정보가 담겨있는 DTO를 넘겨 쿼리문에서 사용하기 위함
        mv.addObject("searchUser", userDTOS);
        mv.setViewName("/content/manager/search/userMain");

        return mv;


//        "/content/manager/search/userMain";
    }

    @GetMapping("/userUpdate")
    public String userUpdate(@RequestParam Long no, Model mv) {


        List<CartDTO> cartDTOS = searchUserService.userBuy(no);
        List<UserReportHistoryDTO> userReportHistoryDTOS = searchUserService.userReport(no);
        List<ProjectDTO> projectDTOS = searchUserService.userFundingProject(no);
        UserDTO userDTOS = searchUserService.findOneUser(no);
        PrivateBusinessDTO privateBusinessDTO = searchUserService.companyInfo(no);

        mv.addAttribute("userInfo", userDTOS);
        mv.addAttribute("companyInfo", privateBusinessDTO);
        mv.addAttribute("userBuy", cartDTOS);
        mv.addAttribute("userReport", userReportHistoryDTOS);
        mv.addAttribute("userFunding", projectDTOS);


        return "/content/manager/search/userUpdate";
    }

    @PostMapping("/userUpdate")
    public String userUpdateQuery(@ModelAttribute UserDTO userDTO,
                                  @ModelAttribute PrivateBusinessDTO privateBusinessDTO,
                                  RedirectAttributes attributes)
            throws NoticeModifyException {
        System.out.println("userDTO ========================== " + userDTO);
        System.out.println("privateBusinessDTO =========================== " + privateBusinessDTO);

        if (userDTO.getUserCode() != 0) {
            searchUserService.userUpdate(userDTO);
        }
        if (privateBusinessDTO.getBusinessCode() != 0) {
            searchUserService.businessUpdate(privateBusinessDTO);

        }

        attributes.addFlashAttribute("message", "수정에 성공했습니다");

        int no = userDTO.getUserCode();
        return "redirect:/manager/search/userDetail?no=" + no;
    }

    @GetMapping("/delete")
    public String userDelete(@RequestParam Long no,
                             HttpServletRequest request,
                             HttpServletResponse response,
                             RedirectAttributes rttr)
    throws MemberRemoveException {
        System.out.println("no =========================== " + no);

        searchUserService.deleteUser(no);

        SessionUtil.invalidateSession(request,response);

        rttr.addFlashAttribute("message", "회원 삭제에 성공했습니다");

        return "redirect:/manager/search/userMain";
    }
}

