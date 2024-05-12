package com.ohgiraffers.semiproject.order.model.service;


import com.ohgiraffers.semiproject.member.model.dto.MemberDTO;
import com.ohgiraffers.semiproject.order.model.dao.PaymentMapper;

import com.ohgiraffers.semiproject.order.model.dto.CartDTO;
import com.ohgiraffers.semiproject.order.model.dto.DeliverDTO;
import com.ohgiraffers.semiproject.order.model.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {


    private  PaymentMapper mapper;

    public PaymentServiceImpl(PaymentMapper mapper) {
        this.mapper = mapper;
    }






    public List<UserDTO>  paymentPage(String userId, int cartCode) {
        List<UserDTO> paymentPage = mapper.user1(userId, cartCode);
        return paymentPage;
    }




    public void deliverInfoUpdate(MemberDTO member){

        int result = mapper.deliverUserInfo(member);

        if(!(result > 0 )){
            System.out.println("배송 정보가 없습니다");
        }
    }


    @Override
    public void updateCount(String cartCode, String counter) {

        System.out.println("===== PaymentService =====");
        System.out.println("CartCode: " + cartCode + ", Counter: " + counter);

        mapper.selectCount(cartCode,counter);
    }

    @Override
    public List<CartDTO> buyList(String cartCode) {

        List<CartDTO> buyList = mapper.buyHistory(cartCode);

        return buyList;
    }




    @Override
    public void insertDeliver( int member) {
        System.out.println("===== PayOk Service =====");
        System.out.println("member = "  + member);
        mapper.insertDeliver(member);
        // 삽입된 배송 정보의 코드를 deliverDTO에 설정

    }



    @Override
    public void insertPay(String price) {
        System.out.println("===== PaymentInsert =====");
        System.out.println("cartCode = " + price);
        mapper.insertPay(price);
    }

    @Override
    public List<DeliverDTO> findDeliveryCode(int member) {

        System.out.println("==== deliveryCode =====");
        List<DeliverDTO> findDeliveryCode = mapper.findDeliverCode(member);

        return findDeliveryCode;
    }


}
