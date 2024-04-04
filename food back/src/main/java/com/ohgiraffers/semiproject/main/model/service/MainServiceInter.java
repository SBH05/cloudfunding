package com.ohgiraffers.semiproject.main.model.service;

import com.ohgiraffers.semiproject.common.paging.SelectCriteria;
import com.ohgiraffers.semiproject.main.model.dto.ProjectDTO;

import java.util.List;
import java.util.Map;

public interface MainServiceInter {

    int selectTotalCount(Map<String, String> searchMap);
    List<List<ProjectDTO>> findAllProject(SelectCriteria selectCriteria);
    List<ProjectDTO> firstNewProject();
    List<ProjectDTO> secondNewProject();
    List<ProjectDTO> firstReProject();
    List<ProjectDTO> secondReProject();
}
