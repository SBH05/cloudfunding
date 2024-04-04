package com.ohgiraffers.semiproject.order.model.service;


import com.ohgiraffers.semiproject.common.exception.member.MemberJoinException;
import com.ohgiraffers.semiproject.common.exception.payment.DeliverInfoException;
import com.ohgiraffers.semiproject.common.exception.payment.PaymentInfoException;
import com.ohgiraffers.semiproject.member.model.dto.MemberDTO;
import com.ohgiraffers.semiproject.order.model.dao.PaymentMapper;

import com.ohgiraffers.semiproject.order.model.dto.CartDTO;
import com.ohgiraffers.semiproject.order.model.dto.DeliverDTO;
import com.ohgiraffers.semiproject.order.model.dto.PaymentHistoryDTO;
import com.ohgiraffers.semiproject.order.model.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


}
