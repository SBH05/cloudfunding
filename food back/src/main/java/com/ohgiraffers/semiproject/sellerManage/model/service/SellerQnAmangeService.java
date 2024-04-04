package com.ohgiraffers.semiproject.sellerManage.model.service;

import com.ohgiraffers.semiproject.common.paging.SelectCriteria;
import com.ohgiraffers.semiproject.sellerManage.model.dao.sellerManage;
import com.ohgiraffers.semiproject.sellerManage.model.dto.SellerManageQnADTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SellerQnAmangeService {

    private final sellerManage Mapper;

    public SellerQnAmangeService(sellerManage mapper) {
        Mapper = mapper;
    }

    public List<SellerManageQnADTO> sellerQnA(int userCode) {

        List<SellerManageQnADTO> sellerQnA = Mapper.sellerQnA(userCode);

        return sellerQnA;
    }

    public int QnAManageTotalCount(Map<String, String> searchMap) {
        int result = Mapper.QnAManageTotalCount(searchMap);
        return result;
    }
}
