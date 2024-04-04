package com.ohgiraffers.semiproject.order.controller;


import com.ohgiraffers.semiproject.common.exception.cart.CartRegistException;
import com.ohgiraffers.semiproject.member.model.dto.MemberAndAuthorityDTO;
import com.ohgiraffers.semiproject.member.model.dto.MemberDTO;
import com.ohgiraffers.semiproject.order.model.dto.*;
import com.ohgiraffers.semiproject.order.model.service.CartService;
import com.ohgiraffers.semiproject.project.product.model.dto.ProjectOptionDTO;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@Slf4j
@RequestMapping("/order/")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }


    @GetMapping("/cart")
    public String cart(
            Model model,
            @ModelAttribute ProjectDTO projectTitle,
            Principal principal

    ) {
    String userId = principal.getName();

    String title = projectTitle.getTitle();
        System.out.println(userId + "============================================================ userId");

        log.info("[OrderController] cartPage ================================== start");
        log.info("[OrderController] cartPage  ================================== {} ", userId);

        List<CartInsertDTO> cartPage = cartService.cart(userId);
        model.addAttribute("cart", cartPage);

        System.out.println("cartPage ======================= " + cartPage);

        return "/content/order/cart";

    }



    @PostMapping("cart")
    public String addToCart(@RequestParam int projectCode,
                            @RequestParam int optionCode,
                            HttpSession session, Model m,
                            @AuthenticationPrincipal MemberAndAuthorityDTO memberAndAuthorityDTO)
            throws CartRegistException {

        int userCode = memberAndAuthorityDTO.getMemberDTO().getUserCode();

        Map<String, Object> addToCart = new HashMap<>();
        addToCart.put("userCode", userCode);
        addToCart.put("projectCode", projectCode);
        addToCart.put("optionCode", optionCode);
        System.out.println(projectCode + "===============================projectCode");
        cartService.insertCart(addToCart);

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setUserCode(userCode); // MemberDTO 객체에 userCode 설정

        ProjectOptionDTO projectOptionDTO = new ProjectOptionDTO();
        projectOptionDTO.setOptionCode(optionCode); // ProjectOptionDTO 객체에 optionCode 설정

        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setCode(projectCode);


        return "redirect:/order/cart";
    }

}
