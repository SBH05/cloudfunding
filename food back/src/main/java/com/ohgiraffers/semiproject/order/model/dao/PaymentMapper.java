package com.ohgiraffers.semiproject.order.model.dao;

import com.ohgiraffers.semiproject.member.model.dto.MemberDTO;
import com.ohgiraffers.semiproject.order.model.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentMapper {
   List<UserDTO> user1(String userId, int cartCode);


  int deliverUserInfo(MemberDTO member);

  void selectCount(String cartCode, String counter);

  List<CartDTO> buyHistory(String cartCode);

  void insertDeliver(int member);

  void insertPay(String price);

  List<DeliverDTO> findDeliverCode(int member);
}





