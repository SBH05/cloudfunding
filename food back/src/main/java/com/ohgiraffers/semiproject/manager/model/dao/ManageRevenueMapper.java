package com.ohgiraffers.semiproject.manager.model.dao;

import com.ohgiraffers.semiproject.common.paging.SelectCriteria;
import com.ohgiraffers.semiproject.manager.model.dto.ProjectDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ManageRevenueMapper {
    int selectTotalCount(Map<String, String> searchMap);

    List<ProjectDTO> findAllProject(SelectCriteria selectCriteria);

    ProjectDTO findOneProject(Long no);
}
