package com.ohgiraffers.semiproject.board.model.dao;

import com.ohgiraffers.semiproject.board.model.dto.QnAAnswerDTO;
import com.ohgiraffers.semiproject.board.model.dto.QnASelectCriteria;
import com.ohgiraffers.semiproject.board.model.dto.QnAhistoryDTO;
import com.ohgiraffers.semiproject.common.paging.SelectCriteria;
import com.ohgiraffers.semiproject.order.model.dto.ProjectDTO;
import com.ohgiraffers.semiproject.sellerManage.model.dto.SellerManageQnADTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface QnAMapper {
    List<SellerManageQnADTO> QnAMain( QnASelectCriteria selectCriteria);

    List<ProjectDTO> projectList();

    void insertQnA(int user, String title, String content, int hiddenProjectCode);

    SellerManageQnADTO answerQ(Long creationNo);

    int selectTotalProjectCount(Map<String, String> searchMap);
}
