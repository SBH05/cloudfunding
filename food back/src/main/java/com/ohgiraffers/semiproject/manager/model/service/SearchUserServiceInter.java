package com.ohgiraffers.semiproject.manager.model.service;

import com.ohgiraffers.semiproject.common.exception.member.MemberRemoveException;
import com.ohgiraffers.semiproject.common.notice.NoticeModifyException;
import com.ohgiraffers.semiproject.common.notice.NoticeRemoveException;
import com.ohgiraffers.semiproject.common.paging.SelectCriteria;
import com.ohgiraffers.semiproject.manager.model.dto.*;

import java.util.List;
import java.util.Map;

public interface SearchUserServiceInter {

    // 모든 사용자 조회
    List<UserDTO> findAllUser(SelectCriteria selectCriteria);

    // 구매목록 조회
     List<CartDTO> userBuy(Long no);

     List<UserReportHistoryDTO> userReport(Long no);

     List<ProjectDTO> userFundingProject(Long no);

     UserDTO findOneUser(Long no);

     int selectTotalCount(Map<String, String> searchMap);

    void userUpdate(UserDTO userDTO)
            throws NoticeModifyException;

    PrivateBusinessDTO companyInfo(Long no);

    void businessUpdate(PrivateBusinessDTO privateBusinessDTO)
            throws NoticeModifyException;

    void deleteUser(Long no) throws MemberRemoveException;
}
