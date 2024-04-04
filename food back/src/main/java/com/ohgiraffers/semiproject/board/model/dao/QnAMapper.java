package com.ohgiraffers.semiproject.board.model.dao;

import com.ohgiraffers.semiproject.board.model.dto.QnAhistoryDTO;
import com.ohgiraffers.semiproject.order.model.dto.ProjectDTO;
import com.ohgiraffers.semiproject.sellerManage.model.dto.SellerManageProjectDTO;
import com.ohgiraffers.semiproject.sellerManage.model.dto.SellerManageQnADTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QnAMapper {
    List<SellerManageQnADTO> QnAMain(String userId);

    SellerManageQnADTO QnAClose(Long creationNo);

    int QnARegist(QnAhistoryDTO qnAhistory);

    List<SellerManageProjectDTO> QnAprojectInfo();

    ProjectDTO projectSellerInfo();
}
