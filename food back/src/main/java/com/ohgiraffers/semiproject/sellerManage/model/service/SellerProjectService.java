package com.ohgiraffers.semiproject.sellerManage.model.service;

import com.ohgiraffers.semiproject.common.paging.SelectCriteria;
import com.ohgiraffers.semiproject.sellerManage.model.dao.sellerManage;
import com.ohgiraffers.semiproject.sellerManage.model.dto.SellerManageProjectDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class SellerProjectService {

    private final sellerManage Mapper;

    public SellerProjectService(sellerManage mapper) {
        Mapper = mapper;
    }

    public List<SellerManageProjectDTO> sellerProject(String userId) {

        List<SellerManageProjectDTO> sellerProject = Mapper.sellerProject(userId);

        return sellerProject;
    }

    public SellerManageProjectDTO sellerProjectDetail() {

        SellerManageProjectDTO sellerProjectDetail = Mapper.sellerProjectDetail();

        return sellerProjectDetail;
    }

    public int selectTotalCount(Map<String, String> searchMap) {

        int result = Mapper.selectTotalCount(searchMap);

        return result;
    }
}
