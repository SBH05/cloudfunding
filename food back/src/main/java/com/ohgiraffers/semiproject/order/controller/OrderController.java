package com.ohgiraffers.semiproject.order.controller;


import com.ohgiraffers.semiproject.member.model.dto.MemberAndAuthorityDTO;
import com.ohgiraffers.semiproject.member.model.dto.MemberDTO;
import com.ohgiraffers.semiproject.order.model.dto.*;
import com.ohgiraffers.semiproject.order.model.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.stream.Collectors;

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
  public String buyPage(@RequestParam("hdCounterValue") String[] hdCounterValues,
                        @RequestParam("cartCode") String[] selectedCartCodes,
                        Model model) {


    System.out.println("=====  buypage ======");

    System.out.println("hdCounterValues = " + Arrays.toString(hdCounterValues));
    System.out.println("selectedCartCodes = " + Arrays.toString(selectedCartCodes));

    List<String> cartCodes = Arrays.asList(selectedCartCodes);
    List<String> counters = Arrays.asList(hdCounterValues);

    // 변환된 리스트 출력
    System.out.println("cartCodes = " + cartCodes);
    System.out.println("counters = " + counters);


    // hdCounterValues 배열에서 값이 비어있지 않은 요소들을 필터링하여 새로운 리스트를 생성합니다.
    List<String> nonEmptyCounters = Arrays.stream(hdCounterValues)
            .filter(counter -> !counter.isEmpty())
            .collect(Collectors.toList());


    // 각각의 cartCode에 대한 buyPage를 불러와 모델에 추가합니다.
    List<CartDTO> buyPageList = new ArrayList<>();

    for (int i = 0; i < cartCodes.size(); i++) {
      String cartCode = cartCodes.get(i);
      String counter = nonEmptyCounters.get(i);
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


  @Transactional
  @PostMapping("buyok")
  public String buyok(@RequestParam("hdCartCode") String[] hdCartCode,
                      @RequestParam("hGun") String price,
                      @AuthenticationPrincipal MemberAndAuthorityDTO memberAndAuthorityDTO){

    System.out.println("=====  buyok ======");

    System.out.println("hdCartCode = " + Arrays.toString(hdCartCode));
    System.out.println("price = " + price);
    List<String> cartCodes = Arrays.asList(hdCartCode);

    int member = memberAndAuthorityDTO.getMemberDTO().getUserCode();

    List<DeliverDTO> deliver = new ArrayList<>();

    for (int i = 0; i < cartCodes.size(); i++) {

      paymentService.insertDeliver(member);

      //paymentService.insertPay(price);

      String cartCode = cartCodes.get(i);
      System.out.println("cartCode = " + cartCode);

      List<DeliverDTO> deliverList = paymentService.findDeliveryCode(member);

      System.out.println("deliverList = " + deliverList);

    }




    return "/content/order/buyok";
  }




    @GetMapping("watchlist")
    public String watchlist(){
        return "/content/order/watchlist";
    }

}
