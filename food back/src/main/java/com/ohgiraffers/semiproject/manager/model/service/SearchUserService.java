package com.ohgiraffers.semiproject.manager.model.service;

import com.ohgiraffers.semiproject.common.exception.member.MemberRemoveException;
import com.ohgiraffers.semiproject.common.notice.NoticeModifyException;
import com.ohgiraffers.semiproject.common.notice.NoticeRemoveException;
import com.ohgiraffers.semiproject.common.paging.SelectCriteria;
import com.ohgiraffers.semiproject.manager.model.dao.SearchUserMapper;
import com.ohgiraffers.semiproject.manager.model.dto.*;
import com.ohgiraffers.semiproject.manager.model.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class SearchUserService implements SearchUserServiceInter{

    private SearchUserMapper Mapper;

    public SearchUserService(SearchUserMapper mapper) {
        Mapper = mapper;
    }

    @Override
    public List<UserDTO> findAllUser(SelectCriteria selectCriteria) {
        List<UserDTO> userDTOS = Mapper.findAllUser(selectCriteria);

        return userDTOS;
    }

    @Override
    public List<CartDTO> userBuy(Long no) {
        List<CartDTO> cartDTOS = Mapper.userBuy(no);
        return cartDTOS;
    }
    @Override
    public List<UserReportHistoryDTO> userReport(Long no) {
        List<UserReportHistoryDTO> userReportHistoryDTOS = Mapper.userReport(no);

        return userReportHistoryDTOS;
    }
    @Override
    public List<ProjectDTO> userFundingProject(Long no) {
        List<ProjectDTO> projectDTOS = Mapper.userFundingProject(no);

        return projectDTOS;
    }
    @Override
    public UserDTO findOneUser(Long no) {
        UserDTO userDTO = Mapper.findOneUser(no);

        return userDTO;
    }

    @Override
    public int selectTotalCount(Map<String, String> searchMap) {

        int result = Mapper.selectTotalCount(searchMap);

        return result;
    }


    @Override
    public PrivateBusinessDTO companyInfo(Long no) {
        PrivateBusinessDTO privateBusinessDTO = Mapper.companyInfo(no);

        return  privateBusinessDTO;
    }

    @Override
    @Transactional
    public void businessUpdate(PrivateBusinessDTO privateBusinessDTO)
    throws NoticeModifyException{


        int userUpdate = Mapper.businessUpdate(privateBusinessDTO);



        if(!(userUpdate > 0)) {
            throw new NoticeModifyException("회사 정보 수정에 실패하셨습니다.");
        }
    }

    @Override
    @Transactional
    public void deleteUser(Long no) throws MemberRemoveException {

        int result = Mapper.deleteUser(no); // user 테이블에서 삭제

        if(!(result > 0)) {
            throw new MemberRemoveException("회원 삭제에 실패하셨습니다.");
        }
    }

    @Override
    @Transactional
    public void userUpdate(UserDTO userDTO)
    throws NoticeModifyException {


        int userUpdate = Mapper.userUpdate(userDTO);



        if(!(userUpdate > 0)) {
            throw new NoticeModifyException("회원 정보 수정에 실패하셨습니다.");
        }


    }




}
