package com.ohgiraffers.semiproject.manager.model.service;

import com.ohgiraffers.semiproject.common.paging.SelectCriteria;
import com.ohgiraffers.semiproject.manager.model.dto.ProjectDTO;

import java.util.List;
import java.util.Map;

public interface ManageRevenueServiceInter {
    int selectTotalCount(Map<String, String> searchMap);

    List<ProjectDTO> findAllProject(SelectCriteria selectCriteria);
    ProjectDTO findOneProject(Long no);
}
