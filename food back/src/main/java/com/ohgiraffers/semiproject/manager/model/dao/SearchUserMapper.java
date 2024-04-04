package com.ohgiraffers.semiproject.manager.model.dao;

import com.ohgiraffers.semiproject.common.paging.SelectCriteria;
import com.ohgiraffers.semiproject.manager.model.dto.*;
import com.ohgiraffers.semiproject.manager.model.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SearchUserMapper {
    /*
    * 사용자 조회 기능
    * 1. 게시판 형태의 폼에 모든 글을 출력한다.
    * 2. 그 중 글을 클릭하면 글의 상세페이지를 출력하는 창으로 넘어간다.
    * 3. 삭제할 수 있다?
    * 4. 수정할 수 있다?
    * 5. 정지할 수 있다?
    * */

    List<UserDTO> findAllUser(SelectCriteria selectCriteria);

    List<PaymentHistoryDTO> userDetail();

    List<CartDTO> userBuy(Long no);

    List<UserReportHistoryDTO> userReport(Long no);

    List<ProjectDTO> userFundingProject(Long no);

    UserDTO findOneUser(Long no);


    int selectTotalCount(Map<String, String> searchMap);

    List<UserDTO> findAllSeller(SelectCriteria selectCriteria);

    int selectTotalSellerCount(Map<String, String> searchMap);

    PrivateBusinessDTO companyInfo(Long no);

    List<UserReportHistoryDTO> findAllComplaint();


//    int cartUpdate(CartDTO cartDTOS);
//
//    int reportUpdate(UserReportHistoryDTO userReportHistoryDTOS);
//
//    int projectUpdate(ProjectDTO projectDTOS);

    int businessUpdate(PrivateBusinessDTO privateBusinessDTO);

    int userUpdate(UserDTO userDTO);

    int deleteUser(Long no);

}
