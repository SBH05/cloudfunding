package com.ohgiraffers.semiproject.member.model.dao;

import com.ohgiraffers.semiproject.member.model.dto.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberMapper {
    int insertMember(MemberDTO member);

    MemberAndAuthorityDTO findByMemberId(String userId);

    String selectMemberById(String userId);

    int updateMember(MemberAndAuthorityDTO member);

    int deleteMember(String userId);


    int sendEmail(UserAndEmailDTO userAndEmailDTO);

    UserAndEmailDTO checkMail(String checkMail);

    int selectLastInsertUserCode();

    int insertAuthor(int userCode);

    String findUserIdByEmailAndName(String email, String userName);

    void saveAuthCode(String authCode, int emailCode);

    Boolean verifyAuthCode(String userId, String email, String authCode);

    void updatePassword(String userId, String encodedPassword);


    MemberDTO findUserCode(String userId, String email);

    MemberDTO searchLoginMember(String userId);

    MemberDTO findByEmail(String email);

    int update(MemberDTO member);

    int updateProfileImage(ProfileImgDTO profileImgDTO);

    int insertProfile(int userCode);

    MemberAndProfileDTO myInfo(String userId);

    ProfileImgDTO finProfile(int userCode);


    MemberDTO findByEmail2(String email);
}
