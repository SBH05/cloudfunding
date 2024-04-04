package com.ohgiraffers.semiproject.order.controller;


import com.ohgiraffers.semiproject.order.model.dto.*;
import com.ohgiraffers.semiproject.order.model.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
@RequestMapping("/order/")
@Slf4j
public class OrderController {


  private final PaymentService paymentService;

  public OrderController(PaymentService paymentService) {
    this.paymentService = paymentService;
  }


  @GetMapping("buypage")
    public String buyPage(){

      return "/content/order/buypage";
  }


  @PostMapping("buypage")
  public String buyPage(@RequestBody Map<String, Object> requestData,
                        Model model) {
    System.out.println("====== buypage controller =====");

    // 받은 데이터 확인
    System.out.println("Received data: " + requestData);

    // cartCode와 counter를 추출합니다.
    List<String> cartCodes = (List<String>) requestData.get("cartCode");
    List<String> counters = (List<String>) requestData.get("counter");

    // 각각의 cartCode에 대한 buyPage를 불러와 모델에 추가합니다.
    List<CartDTO> buyPageList = new ArrayList<>();
    for (int i = 0; i < cartCodes.size(); i++) {
      String cartCode = cartCodes.get(i);
      String counter = counters.get(i);
      System.out.println("CartCode: " + cartCode + ", Counter: " + counter);

      // 수량 업데이트
      paymentService.updateCount(cartCode, counter);

      // cartCode에 대한 buyPage를 가져옵니다.
      List<CartDTO> buyPage = paymentService.buyList(cartCode);
      buyPageList.addAll(buyPage);
      System.out.println("buyPage ======================= " + buyPage);
    }

    // 모델에 buyPageList를 추가하여 뷰 페이지로 전달합니다.
    model.addAttribute("buyPageList", buyPageList);
    System.out.println("buyPageList = " + buyPageList);

    // 이동할 페이지의 경로를 반환합니다.
    return "/content/order/buypage";
  }



  @GetMapping("buyok")
  public String buyok(){
    return "/content/order/buyok";
  }




    @GetMapping("watchlist")
    public String watchlist(){
        return "/content/order/watchlist";
    }
}
