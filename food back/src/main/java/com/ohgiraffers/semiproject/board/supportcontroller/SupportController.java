package com.ohgiraffers.semiproject.board.supportcontroller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/support/*")
public class SupportController {


    @GetMapping("sellermain")
    public String sellerMain(){

        return "content/board/memberSupport/sellerSupportMain"; }



    @GetMapping("sellerwrited")
    public String sellerWrited(){

        return "content/board/memberSupport/sellerSupportWrited";
    }



    @GetMapping("sellerwriting")
    public String sellerWriting(){

        return "content/board/memberSupport/sellerSupportWriting";
    }



    @GetMapping("sellerRE")
    public String sellerRE(){

        return "content/board/memberSupport/sellerSupportRE"; }



    @GetMapping("userRE")
    public String userRE(){

        return "content/board/memberSupport/userSupportRE"; }




    @GetMapping("userwriting")
    public String userWriting(){

        return "content/board/memberSupport/userSupportWriting";
    }



    @GetMapping("userwrited")
    public String userWrited(){

        return "content/board/memberSupport/userSupportWrited";
    }


    @GetMapping("usermain")
    public String userMain(){

        return "content/board/memberSupport/userSupportMain";
    }





}
