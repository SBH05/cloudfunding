package com.ohgiraffers.semiproject.manager.model.service;

import com.ohgiraffers.semiproject.common.notice.NoticeModifyException;
import com.ohgiraffers.semiproject.common.notice.NoticeRegistException;
import com.ohgiraffers.semiproject.common.notice.NoticeRemoveException;
import com.ohgiraffers.semiproject.common.paging.SelectCriteria;
import com.ohgiraffers.semiproject.manager.model.dao.ManageProjectMapper;
import com.ohgiraffers.semiproject.manager.model.dto.ApprovalHistoryDTO;
import com.ohgiraffers.semiproject.manager.model.dto.ProjectDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service
@Slf4j
public class ManageProjectService implements ManageProjectServiceInter{


    private final ManageProjectMapper mapper;

    public ManageProjectService(ManageProjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public int selectTotalCount(Map<String, String> searchMap) {
        int result = mapper.selectTotalCount(searchMap);

        return result;
    }

    @Override
    public List<ProjectDTO> findAllProject(SelectCriteria selectCriteria) {
        List<ProjectDTO> userDTOS = mapper.findAllProject(selectCriteria);

        return userDTOS;
    }

    @Override
    public ProjectDTO findOneProject(Long no) {
        ProjectDTO projectDTO = mapper.findOneProject(no);

        return projectDTO;
    }

    @Override
    public String findStatus(Long no) {
        int status1 = mapper.findStatus(no);
        String status = null;

        System.out.println("status ========================== " + status);

        if(status1 == 1){
            char result = mapper.status(no);
            System.out.println("result =============== " + result);
            if(result == 'N'){
                status = "반려";
            } else if (result == 'Y') {
                status = "승인";
            }

        } else if (status1 == 0){
            status = "신규";
        }

        return status;
    }

    @Override
    @Transactional
    public void declineReason(ApprovalHistoryDTO approvalHistoryDTO) throws NoticeRegistException {

        int declineReason = mapper.declineReason(approvalHistoryDTO);

        if(!(declineReason > 0)) {
            throw new NoticeRegistException("회원 정보 수정에 실패하셨습니다.");
        }
    }

    @Override
    @Transactional
    public void approve(Long no) throws NoticeRegistException {
        int result = mapper.approve(no);

        if(!(result > 0)) {
            throw new NoticeRegistException("회원 정보 수정에 실패하셨습니다.");
        }
    }
}
