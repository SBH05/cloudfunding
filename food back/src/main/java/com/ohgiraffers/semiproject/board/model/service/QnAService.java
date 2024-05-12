package com.ohgiraffers.semiproject.board.model.service;


import com.ohgiraffers.semiproject.board.model.dao.QnAMapper;
import com.ohgiraffers.semiproject.board.model.dto.QnASelectCriteria;
import com.ohgiraffers.semiproject.order.model.dto.ProjectDTO;
import com.ohgiraffers.semiproject.sellerManage.model.dto.SellerManageQnADTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class QnAService implements QnAServiceInter {

    private final QnAMapper mapper;



    public QnAService(QnAMapper mappper) {
        this.mapper = mappper;
    }

    public List<SellerManageQnADTO> QnAMainPage(QnASelectCriteria selectCriteria) {

        List<SellerManageQnADTO>QnAMainDTO = mapper.QnAMain(selectCriteria);

        return QnAMainDTO;
    }


    public SellerManageQnADTO QnAAnswer(Long creationNo) {
        SellerManageQnADTO answer = mapper.answerQ(creationNo);
        return answer;
    }



    public List<ProjectDTO> projectTitle() {

        List<ProjectDTO> projects = mapper.projectList();
        return projects;
    }


    public void insertQnA(int user, String title, String content, int hiddenProjectCode) {
        mapper.insertQnA(user,title,content,hiddenProjectCode);
    }


    public int selectTotalProjectCount(Map<String, String> searchMap) {
        int result = mapper.selectTotalProjectCount(searchMap);
        return result;
    }


}
