package com.ohgiraffers.semiproject.member.model.service;

import com.ohgiraffers.semiproject.common.exception.member.MemberJoinException;
import com.ohgiraffers.semiproject.common.exception.member.MemberRemoveException;
import com.ohgiraffers.semiproject.common.exception.member.MemberUpdateException;
import com.ohgiraffers.semiproject.member.emailsender.EmailSender;
import com.ohgiraffers.semiproject.member.model.dao.MemberMapper;
import com.ohgiraffers.semiproject.member.model.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class MemberServiceImpl implements MemberService {
    private final PasswordEncoder passwordEncoder;
    private final MemberMapper mapper;

    private final EmailSender emailSender;





    public MemberServiceImpl(PasswordEncoder passwordEncoder, MemberMapper mapper, EmailSender emailSender) {
        this.passwordEncoder = passwordEncoder;
        this.mapper = mapper;
        this.emailSender = emailSender;
    }



    private String generateRandomString(int length) {
        String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = secureRandom.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(randomIndex));
        }
        return sb.toString();
    }





    @Transactional
    @Override
    public void joinMember(MemberDTO memberDTO) throws MemberJoinException {




        log.info("[MemberService] Insert Member : " + memberDTO);

        int result = mapper.insertMember(memberDTO);

        int userCode = mapper.selectLastInsertUserCode(); // tbl_user 에서 마지막 입력한 pk 값.
        System.out.println(userCode+"==============================userCode============================================");
        log.info(String.valueOf(result));
        log.info(String.valueOf(userCode));
//        throw new MemberJoinException("임시 오류");
        int result1 = mapper.insertAuthor(userCode); // tbl_authority_list에 넣는 값. // insert #{userCode}, 권한명
        int result2 = mapper.insertProfile(userCode);

        System.out.println("result1.getUserId()========== : ");

        log.info("[MemberService] Insert result : " + ((result > 0) ? "회원가입 성공" : "회원가입 실패"));
        log.info("[MemberService] Insert result : " + ((result1 > 0) ? "권한주기 성공" : "회원가입 실패"));
        log.info("[MemberService] Insert result : " + ((result2 > 0) ? "기본프로필 등록 성공" : "회원가입 실패"));

        if(!(result > 0 )){
            throw new MemberJoinException("회원 가입에 실패하였습니다.");
        }
    }





    @Override
    public boolean selectMemberById(String userId) {

        String result = mapper.selectMemberById(userId);

        return result != null? true : false;
    }



    @Override
    public MemberAndAuthorityDTO removeMember(String userId) throws MemberRemoveException {
        int result = mapper.deleteMember(userId);

        if(!(result > 0)) {
            throw new MemberRemoveException("회원 탈퇴에 실패하셨습니다.");
        }


        return null;
    }

    @Override
    public boolean isEmailAvailable(String email) {
        // 데이터베이스에서 이메일 조회
        MemberDTO memberDTO = mapper.findByEmail(email);
        // 이메일이 존재하지 않으면 true, 존재하면 false 반환
        return memberDTO == null;
    }



    @Override
    @Transactional
    public void updateMember(MemberDTO member) throws MemberUpdateException {
        System.out.println("updateMember member ================= " + member);
        int result = mapper.update(member);
        if(!(result > 0)) {
            throw new MemberUpdateException("회원 정보 수정에 실패하셨습니다.");
        }
    }

    @Override
    @Transactional
    public int sendEmail(String email) {
        EmailSender es = new EmailSender();
        String randomStr = generateRandomString(6);
        es.emailSend(email,randomStr);
    // 데이터베이스에 추가
        UserAndEmailDTO userAndEmailDTO = new UserAndEmailDTO();
        userAndEmailDTO.setEmailCerti(randomStr);

        int result = mapper.sendEmail(userAndEmailDTO);
        // 로직
        System.out.println("userAndEmailDTO = " + userAndEmailDTO); // 시퀀스 번호가 다시 조회되어서 출력

        return userAndEmailDTO.getEmailCode();

    }
    @Transactional
    @Override
    public boolean checkMail(String checkMail) {
        UserAndEmailDTO userAndEmailDTO = mapper.checkMail(checkMail);

        System.out.println(userAndEmailDTO.getEmailCode());

        // 이메일 인증 코드를 통해 조회된 데이터가 없으면 false 반환
        if (userAndEmailDTO.getEmailCerti() == null) {
            return false;
        }

        // 대소문자를 구분하지 않고 비교
        return userAndEmailDTO.getEmailCerti().equalsIgnoreCase(checkMail);
    }






    @Override
    public String findUserIdByEmail(MemberDTO memberDTO) {
        String userId = mapper.findUserIdByEmailAndName(memberDTO.getEmail(), memberDTO.getUserName());
        if (userId != null && emailSender.sendUserId(memberDTO.getEmail(), userId)) {
            return userId;
        }
        return null;
    }


    @Transactional
    @Override
    public void sendAuthCodeToEmail(String userId, String email) {
        String authCode = generateRandomString(6); // 인증번호 생성 로직
        MemberDTO memberDTO = mapper.findUserCode(userId, email);
        int emailCode = memberDTO.getEmailCode();
        mapper.saveAuthCode(authCode, emailCode); // DB에 인증번호 저장
        emailSender.sendEmail(email, "인증번호", "귀하의 인증번호는 " + authCode + " 입니다."); // 이메일 발송
    }

    // 비밀번호 복구 로직

    @Override
    public boolean verifyAuthCode(String userId, String email, String authCode) {
        Boolean result = mapper.verifyAuthCode(userId, email, authCode);
        if (result == null) {
            // 예상치 못한 상황, 적절히 처리
            return false;
        }
        return result;
    }
    @Override
    public String createAndSendTempPassword(String userId, String email) {
        String tempPassword = generateRandomString(8);
        String encodedPassword = passwordEncoder.encode(tempPassword);
        mapper.updatePassword(userId, encodedPassword);
        emailSender.sendEmail1(email, "CloudFooding임시 비밀번호", "귀하의 임시 비밀번호는 " + tempPassword + " 입니다.");
        return tempPassword;
    }

    @Override
    public ProfileImgDTO findProfile(int userCode) {

        ProfileImgDTO profileImgDTO = mapper.finProfile(userCode);
        return profileImgDTO;
    }

    @Override
    public boolean checkEmailDuplication(String email) {
        // MemberMapper를 사용하여 이메일 주소로 데이터베이스를 조회합니다.
        // 해당 이메일로 등록된 사용자가 있으면 MemberDTO 객체를, 없으면 null을 반환합니다.
        MemberDTO member = mapper.findByEmail2(email);

        // member가 null이면 이메일이 중복되지 않았음을 의미합니다.
        // 따라서, member가 null이면 true를, 그렇지 않으면 false를 반환합니다.
        return member == null;
    }


    public MemberDTO searchLoginMember(String userId) {
        if (userId == null || userId.trim().isEmpty()) {
            // userId가 유효하지 않은 경우에 대한 처리
            throw new IllegalArgumentException("Invalid user ID");
        }

        MemberDTO memberDTO = mapper.searchLoginMember(userId);

        if (memberDTO == null) {
            // 사용자 정보가 없는 경우에 대한 처리
            throw new NoSuchElementException("No user found with the provided user ID");
        }

        return memberDTO;
    }


    public void updateProfileImage(ProfileImgDTO profileImgDTO) {
        int result = mapper.updateProfileImage(profileImgDTO);
        if(result>0){
            System.out.println("프로필 업로드 성공!");

        }else {
            System.out.println("프로필 업로드 실패!");
        }
    }

    public MemberAndProfileDTO myInfo(String userId) {

        MemberAndProfileDTO memberAndProfileDTO = mapper.myInfo(userId);

        return memberAndProfileDTO;
    }
}

