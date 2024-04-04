package com.ohgiraffers.semiproject.board.model.service;


import com.ohgiraffers.semiproject.board.model.dao.QnAMapper;
import com.ohgiraffers.semiproject.board.model.dto.QnAhistoryDTO;
import com.ohgiraffers.semiproject.common.notice.QnARegistException;
import com.ohgiraffers.semiproject.order.model.dto.ProjectDTO;
import com.ohgiraffers.semiproject.sellerManage.model.dto.SellerManageProjectDTO;
import com.ohgiraffers.semiproject.sellerManage.model.dto.SellerManageQnADTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class QnAService implements QnAServiceInter {

    private final QnAMapper mapper;

    public QnAService(QnAMapper mappper) {
        this.mapper = mappper;
    }

    public List<SellerManageQnADTO> QnAMainPage(String userId) {

        List<SellerManageQnADTO>QnAMainDTO = mapper.QnAMain(userId);

        return QnAMainDTO;
    }

    public SellerManageQnADTO QnAClosePage(Long creationNo) {
        SellerManageQnADTO QnAClose = mapper.QnAClose(creationNo);
        return QnAClose;
    }


    public void registQnA(QnAhistoryDTO qnAhistory) throws QnARegistException{

        int result = mapper.QnARegist(qnAhistory);

        if(!(result > 0)){
            throw new QnARegistException("등록에 실패했습니다");
        }
    }

    public  List<SellerManageProjectDTO> projectinformation() {

        List<SellerManageProjectDTO> projectinformation = mapper.QnAprojectInfo();

        return projectinformation;
    }

    public ProjectDTO projectSellerInfo() {
        ProjectDTO projectSellerInfo = mapper.projectSellerInfo();
        return projectSellerInfo;
    }
}
