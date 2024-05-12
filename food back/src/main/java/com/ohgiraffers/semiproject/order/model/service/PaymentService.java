package com.ohgiraffers.semiproject.order.model.service;


import com.ohgiraffers.semiproject.order.model.dto.CartDTO;
import com.ohgiraffers.semiproject.order.model.dto.DeliverDTO;


import java.util.List;

public interface PaymentService {
    void updateCount(String cartCode, String counter);

    List<CartDTO> buyList(String cartCode);

    void insertDeliver(int member);

    void insertPay(String price);

    List<DeliverDTO> findDeliveryCode(int member);


//    결제 취소






}
