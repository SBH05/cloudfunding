package com.ohgiraffers.semiproject.manager.model.service;

import com.ohgiraffers.semiproject.common.notice.NoticeRegistException;
import com.ohgiraffers.semiproject.common.notice.NoticeRemoveException;
import com.ohgiraffers.semiproject.common.paging.SelectCriteria;
import com.ohgiraffers.semiproject.manager.model.dto.ApprovalHistoryDTO;
import com.ohgiraffers.semiproject.manager.model.dto.ProjectDTO;

import java.util.List;
import java.util.Map;

public interface ManageProjectServiceInter {


    int selectTotalCount(Map<String, String> searchMap);

    List<ProjectDTO> findAllProject(SelectCriteria selectCriteria);

    ProjectDTO findOneProject(Long no);

    String findStatus(Long no);

    void declineReason(ApprovalHistoryDTO approvalHistoryDTO) throws NoticeRegistException;

    void approve(Long no)throws NoticeRegistException;
}
