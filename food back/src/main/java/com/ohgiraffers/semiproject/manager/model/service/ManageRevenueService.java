package com.ohgiraffers.semiproject.manager.model.service;

import com.ohgiraffers.semiproject.common.paging.SelectCriteria;
import com.ohgiraffers.semiproject.manager.model.dao.ManageRevenueMapper;
import com.ohgiraffers.semiproject.manager.model.dto.ProjectDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ManageRevenueService implements ManageRevenueServiceInter{

    private ManageRevenueMapper mapper;

    public ManageRevenueService(ManageRevenueMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public int selectTotalCount(Map<String, String> searchMap) {
        int projectDTOList = mapper.selectTotalCount(searchMap);

        return projectDTOList;
    }

    @Override
    public List<ProjectDTO> findAllProject(SelectCriteria selectCriteria) {
        List<ProjectDTO> projectDTOS = mapper.findAllProject(selectCriteria);

        return projectDTOS;
    }
    @Override
    public ProjectDTO findOneProject(Long no) {

        ProjectDTO projectDTO = mapper.findOneProject(no);

        return projectDTO;

    }
}
