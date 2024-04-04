package com.ohgiraffers.semiproject.sellerManage.model.dao;

import com.ohgiraffers.semiproject.common.paging.SelectCriteria;
import com.ohgiraffers.semiproject.sellerManage.model.dto.SellerManageProjectDTO;
import com.ohgiraffers.semiproject.sellerManage.model.dto.SellerManageQnADTO;
import com.ohgiraffers.semiproject.sellerManage.model.dto.SellerUserMangeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface sellerManage {


    List<SellerManageProjectDTO> sellerProject(String userId);

    SellerManageProjectDTO sellerProjectDetail();

    int selectTotalCount(Map<String, String> searchMap);

    List<SellerUserMangeDTO> sellerUser(String userId, int userCode);

    List<SellerManageQnADTO> sellerQnA(int userId);

    int QnAManageTotalCount(Map<String, String> searchMap);


}
