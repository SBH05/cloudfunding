package com.ohgiraffers.semiproject.manager.model.dao;

import com.ohgiraffers.semiproject.common.paging.SelectCriteria;
import com.ohgiraffers.semiproject.manager.model.dto.ApprovalHistoryDTO;
import com.ohgiraffers.semiproject.manager.model.dto.ProjectDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ManageProjectMapper {

    List<ProjectDTO> newProject();

    int selectTotalCount(Map<String, String> searchMap);

    List<ProjectDTO> findAllProject(SelectCriteria selectCriteria);

    ProjectDTO findOneProject(Long no);

    int findStatus(Long no);

    char status(Long no);

    int declineReason(ApprovalHistoryDTO approvalHistoryDTO);

    int approve(Long no);
}
