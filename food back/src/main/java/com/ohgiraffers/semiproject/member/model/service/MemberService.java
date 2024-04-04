package com.ohgiraffers.semiproject.member.model.service;

import com.ohgiraffers.semiproject.common.exception.member.MemberJoinException;
import com.ohgiraffers.semiproject.common.exception.member.MemberRemoveException;
import com.ohgiraffers.semiproject.common.exception.member.MemberUpdateException;
import com.ohgiraffers.semiproject.member.model.dto.MemberAndAuthorityDTO;
import com.ohgiraffers.semiproject.member.model.dto.MemberAndProfileDTO;
import com.ohgiraffers.semiproject.member.model.dto.MemberDTO;
import com.ohgiraffers.semiproject.member.model.dto.ProfileImgDTO;

public interface MemberService {




    void joinMember(MemberDTO memberDTO) throws MemberJoinException;

    boolean selectMemberById(String userId);



    MemberAndAuthorityDTO removeMember(String userId) throws MemberRemoveException;

    boolean isEmailAvailable(String email);

    void updateMember(MemberDTO member)throws MemberUpdateException;

    int sendEmail(String email);

    boolean checkMail(String checkMail);


    String findUserIdByEmail(MemberDTO memberDTO);


    void sendAuthCodeToEmail(String userId, String email);




    boolean verifyAuthCode(String userId, String email, String authCode);

    String createAndSendTempPassword(String userId, String email);

    ProfileImgDTO findProfile(int userCode);

    boolean checkEmailDuplication(String email);
}
