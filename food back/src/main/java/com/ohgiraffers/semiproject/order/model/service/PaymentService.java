package com.ohgiraffers.semiproject.order.model.service;


import com.ohgiraffers.semiproject.common.exception.payment.DeliverInfoException;
import com.ohgiraffers.semiproject.common.exception.payment.PaymentInfoException;
import com.ohgiraffers.semiproject.common.exception.payment.PaymentPageException;

import com.ohgiraffers.semiproject.member.model.dto.MemberDTO;
import com.ohgiraffers.semiproject.order.model.dto.CartDTO;
import com.ohgiraffers.semiproject.order.model.dto.DeliverDTO;
import com.ohgiraffers.semiproject.order.model.dto.PaymentHistoryDTO;
import com.ohgiraffers.semiproject.order.model.dto.UserDTO;


import java.util.Date;
import java.util.List;
import java.util.Map;

public interface PaymentService {
    void updateCount(String cartCode, String counter);

    List<CartDTO> buyList(String cartCode);


//    결제 취소






}
