package com.ohgiraffers.semiproject.board.model.service;

import com.ohgiraffers.semiproject.board.model.dto.QnAhistoryDTO;
import com.ohgiraffers.semiproject.common.notice.QnARegistException;
import com.ohgiraffers.semiproject.order.model.dto.ProjectDTO;
import com.ohgiraffers.semiproject.sellerManage.model.dto.SellerManageQnADTO;

import java.util.List;

public interface QnAServiceInter {

    List<SellerManageQnADTO> QnAMainPage(String userId);

    SellerManageQnADTO QnAClosePage(Long creationNo);

    void registQnA(QnAhistoryDTO qnAhistory) throws QnARegistException;



}
