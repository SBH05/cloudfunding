package com.ohgiraffers.semiproject.main.controller;

import com.ohgiraffers.semiproject.main.model.service.MainService;
import com.ohgiraffers.semiproject.main.model.dto.ProjectDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {

    private final MainService mainService;

    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/")
    public ModelAndView defaultLocation(ModelAndView mv){

        List<ProjectDTO> projectDTO = mainService.firstNewProject(); // 신규펀딩 첫번째 행
        List<ProjectDTO> projectDTOS = mainService.secondNewProject(); // 신규펀딩 두번째 행 불러오는걸 목표로

        List<ProjectDTO> projectDTOList = mainService.firstReProject();
        List<ProjectDTO> projectDTOS1 = mainService.secondReProject();


//        출력 확인
//        System.out.println("projectDTO: " + projectDTO);
//        System.out.println("projectDTOS: " + projectDTOS);
//        System.out.println("projectDTOList: " + projectDTOList);
//        System.out.println("projectDTOS1: " + projectDTOS1);

        mv.addObject("firstProject", projectDTO);
        mv.addObject("secondProject", projectDTOS);
        mv.addObject("re1", projectDTOList);
        mv.addObject("re2", projectDTOS1);
        mv.setViewName("index");

        return mv;
    }


}
