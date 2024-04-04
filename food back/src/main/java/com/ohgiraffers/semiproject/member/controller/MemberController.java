package com.ohgiraffers.semiproject.member.controller;

import com.ohgiraffers.semiproject.common.exception.member.MemberJoinException;
import com.ohgiraffers.semiproject.common.exception.member.MemberUpdateException;
import com.ohgiraffers.semiproject.common.exception.member.MemberRemoveException;
import com.ohgiraffers.semiproject.common.util.SessionUtil;
import com.ohgiraffers.semiproject.member.emailsender.EmailSender;
import com.ohgiraffers.semiproject.member.model.dto.MemberAndAuthorityDTO;
import com.ohgiraffers.semiproject.member.model.dto.MemberAndProfileDTO;
import com.ohgiraffers.semiproject.member.model.dto.MemberDTO;
import com.ohgiraffers.semiproject.member.model.dto.ProfileImgDTO;
import com.ohgiraffers.semiproject.member.model.service.MemberServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.*;

@Controller
@RequestMapping("/member")
@Slf4j
public class MemberController {



    @Value("C:/uploadfile")
    private String ROOT_LOCATION;
    private final PasswordEncoder passwordEncoder;
    private final MemberServiceImpl memberService;

    private final EmailSender emailSender;



    public MemberController(PasswordEncoder passwordEncoder, MemberServiceImpl memberService, EmailSender emailSender) {
        this.passwordEncoder = passwordEncoder;
        this.memberService = memberService;
        this.emailSender = emailSender;
    }
    @GetMapping("login")
    public String login() {


        return "/content/member/login/login";

    }

    @GetMapping("join")
    public String join() {


        return "/content/member/login/join";

    }
    @PostMapping("join")
    public String joinMember(@ModelAttribute MemberDTO member,
                               @RequestParam String zipCode,
                               @RequestParam String address1,
                               @RequestParam String address2,
                               @RequestParam int hdValue,
                               RedirectAttributes rttr) throws MemberJoinException {


        String address = zipCode + "@" + address1 + "@" + address2;
        member.setEmailCode(hdValue);
        member.setPhone(member.getPhone().replace("-",""));
        member.setAddress(address);
        member.setUserPwd(passwordEncoder.encode(member.getUserPwd()));
        log.info("[MemberController] joinMember request Member : " + member);

        memberService.joinMember(member);

        rttr.addFlashAttribute("message", "회원 가입에 성공하였습니다.");

        log.info("[MemberController] joinMember ========================================================== end");

        return "redirect:/";
    }



    @PostMapping("idDupCheck")
    public ResponseEntity<String> checkDuplication(@RequestBody MemberDTO member) {

        log.info("");
        log.info("");
        log.info("[MemberController] checkDuplication ========================================================== start");

        String result = "사용 가능한 아이디 입니다.";
        log.info("[MemberController] Request Check ID : " + member.getUserId());

        if("".equals(member.getUserId())) {
            log.info("[MemberController] No Input User ID");
            result = "아이디를 입력해 주세요";
        } else if(memberService.selectMemberById(member.getUserId())) {
            log.info("[MemberController] Already Exist");
            result = "중복된 아이디가 존재합니다.";
        }

        log.info("[MemberController] checkDuplication ========================================================== end");

        return ResponseEntity.ok(result);
    }




    @GetMapping("findId")
    public String findId() {


        return "/content/member/login/findId";

    }

    @PostMapping("findUserId")
    @ResponseBody
    public ResponseEntity<?> findUserId(@RequestBody MemberDTO memberDTO) {
        String userId = memberService.findUserIdByEmail(memberDTO);
        if (userId != null && !userId.isEmpty()) {
            return ResponseEntity.ok(Map.of("success", true, "message", "ID가 이메일로 발송되었습니다."));
        } else {
            return ResponseEntity.ok(Map.of("success", false, "message", "사용자를 찾을 수 없습니다."));
        }
    }


    @GetMapping("findPwd")
    public String findPwd() {


        return "/content/member/login/findPwd";

    }


    @PostMapping("requestAuthCode")
    @ResponseBody
    public ResponseEntity<?> requestAuthCode(@RequestParam("userId") String userId,
                                             @RequestParam("email") String email) {
        try {
            memberService.sendAuthCodeToEmail(userId, email);
            return ResponseEntity.ok("{\"message\": \"인증번호가 이메일로 발송되었습니다.\"}");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\": \"인증번호 발송에 실패했습니다.\"}");
        }
    }

    @PostMapping("verifyAuthCode")
    @ResponseBody
    public ResponseEntity<?> verifyAuthCode(
                                            @RequestParam("userId") String userId,
                                            @RequestParam("email") String email,
                                            @RequestParam("authCode") String authCode) {
        try {
            if (memberService.verifyAuthCode(userId, email, authCode)) {
                return ResponseEntity.ok("{\"message\": \"인증이 확인되었습니다.\"}");
            } else {
                return ResponseEntity.badRequest().body("{\"error\": \"유효하지 않은 인증번호입니다.\"}");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\": \"인증 확인에 실패했습니다.\"}");
        }
    }
    @PostMapping("createTempPassword")
    @ResponseBody
    public ResponseEntity<?> createTempPassword(@RequestParam("userId") String userId,
                                                @RequestParam("email") String email) {
        try {
            String tempPassword = memberService.createAndSendTempPassword(userId, email);
            return ResponseEntity.ok("{\"message\": \"임시 비밀번호가 이메일로 발송되었습니다.\"}");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\": \"임시 비밀번호 생성 및 발송에 실패했습니다.\"}");
        }
    }




    @PostMapping("/email-check")
    @ResponseBody
    public Map<String, Boolean> checkEmailAvailability(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        boolean result = memberService.isEmailAvailable(email);
        return Collections.singletonMap("isEmailAvailable", result);
    }





    @PostMapping(value = "inputFile")
    @ResponseBody
    @Transactional
    public ResponseEntity<?> insertImgFile(
            @RequestParam("file-input") MultipartFile multipartFile, Principal principal) {

        String username = principal.getName();
        MemberDTO memberDTO = memberService.searchLoginMember(username);

        int userCode = memberDTO.getUserCode();

        System.out.println("multipartFile=============================================" + multipartFile);

        System.out.println("=============================================userCode" + userCode);
        if (!multipartFile.isEmpty()) {
            String rootLocation = ROOT_LOCATION;
            String fileUploadDirectory = rootLocation + "/profileimg";
            File directory = new File(fileUploadDirectory);

            if (!directory.exists()) {
                directory.mkdirs();
            }

            String originFileName = multipartFile.getOriginalFilename();
            String ext = originFileName.substring(originFileName.lastIndexOf("."));
            String savedFileName = UUID.randomUUID().toString().replace("-", "") + ext;

            try {
                multipartFile.transferTo(new File(fileUploadDirectory + "/" + savedFileName));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            ProfileImgDTO profileImgDTO = new ProfileImgDTO();
            profileImgDTO.setOriginalFileName(originFileName);
            profileImgDTO.setPath(fileUploadDirectory);
            profileImgDTO.setChangedproFileName(savedFileName);
            profileImgDTO.setDeleteStatus("N");
            profileImgDTO.setCreationDate(new Date());
            profileImgDTO.setUserCode(userCode);
            memberService.updateProfileImage(profileImgDTO);

            // 성공 응답 반환
            return ResponseEntity.ok(Collections.singletonMap("message", "Image uploaded successfully"));
        }

        // 실패 응답 반환
        return ResponseEntity.badRequest().body(Collections.singletonMap("error", "No file provided"));
    }


    @PostMapping(value = "update-info", produces = "application/json; charset=utf-8")
    @ResponseBody
    public ResponseEntity<?> updateMemberInfo(@ModelAttribute MemberDTO member, BindingResult result, Principal principal,
                                              @RequestParam String zipCode,
                                              @RequestParam String address1,
                                              @RequestParam String address2
                                              ) {



        String username = principal.getName(); // 현재 사용자의 이름(아이디) 가져오기

        member.setUserId(username);
        System.out.println("username = " + username);



        System.out.println("==========================================시작");
        System.out.println("========================================== member : " + member);

        if (result.hasErrors()) {
            // 입력 데이터에 오류가 있는 경우 에러 메시지 반환
            return ResponseEntity.badRequest().body(Collections.singletonMap("success", false));
        }

        // 주소 합치기
        String address = String.join("@", zipCode, address1, address2);
        member.setAddress(address);

        // 전화번호 형식 정리
        member.setPhone(member.getPhone().replace("-", ""));

        // 비밀번호가 변경되었는지 확인 후 처리
        if (!member.getUserPwd().isEmpty()) {
            member.setUserPwd(passwordEncoder.encode(member.getUserPwd()));
        }try {
            // 회원 정보 업데이트
            memberService.updateMember(member);




            // 세션 무효화 및 기타 후처리 로직 (필요한 경우)
            // ...

            // 성공 메시지 반환
            return ResponseEntity.ok(Collections.singletonMap("success", true));
        } catch (Exception e) {
            e.printStackTrace();
            // 예외 발생 시 에러 메시지 반환
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", e.getMessage()));
        }





    }


    @GetMapping("changeInfo")
    public String searchLoginMember(Principal principal, Model model){
        String username = principal.getName();
        MemberDTO memberDTO = memberService.searchLoginMember(username);
        int userCode = memberDTO.getUserCode();
        ProfileImgDTO profileImgDTO = memberService.findProfile(userCode);
        if (memberDTO != null && memberDTO.getAddress() != null) {
            String[] addressParts = memberDTO.getAddress().split("@");
            if (addressParts.length == 3) {
                model.addAttribute("zipCode", addressParts[0]);
                model.addAttribute("address1", addressParts[1]);
                model.addAttribute("address2", addressParts[2]);


            }
        }

        model.addAttribute("memberDTO", memberDTO);
        model.addAttribute("profileImgDTO", profileImgDTO);
        System.out.println("model ======================================================== " + model);
        return "/content/member/login/changeInfo"; // 뷰의 이름을 반환
    }




    @GetMapping("myInfo")
    public String myInfo(Principal principal, Model model){
        String userId = principal.getName();
        MemberAndProfileDTO memberAndProfileDTO = memberService.myInfo(userId);

        if (memberAndProfileDTO != null && memberAndProfileDTO.getMemberDTO().getAddress() != null) {
            String[] addressParts = memberAndProfileDTO.getMemberDTO().getAddress().split("@");
            if (addressParts.length == 3) {
                model.addAttribute("zipCode", addressParts[0]);
                model.addAttribute("address1", addressParts[1]);
                model.addAttribute("address2", addressParts[2]);


            }
        }

        model.addAttribute("memberAndProfileDTO", memberAndProfileDTO);
        System.out.println("memberAndProfileDTO===========================" + memberAndProfileDTO);
        System.out.println("model ======================================================== " + model);

        return "/content/member/login/myInfo";
    }





    @GetMapping("delete")
    public String deleteMember( Principal principal,
                               RedirectAttributes rttr,
                               HttpServletRequest request,
                               HttpServletResponse response) throws MemberRemoveException {

        log.info("");
        log.info("");
        log.info("[MemberController] deleteMember ========================================================== start");

        String userId = principal.getName();
        System.out.println(userId + " =======================================================");
        MemberAndAuthorityDTO memberAndAuthorityDTO = memberService.removeMember(userId);


        // 회원 탈퇴후 로그아웃 프로세스 진행
        SessionUtil.invalidateSession(request, response);

        rttr.addFlashAttribute("message", "회원 탈퇴에 성공하셨습니다. 로그아웃됩니다.");

        log.info("[MemberController] deleteMember ========================================================== end");




        return "redirect:/";
    }



    @GetMapping("sellerWithdrawal")
    public String sellerWithdrawal() {


        return "/content/member/memberWithdrawal/seller/sellerWithdrawal";

    }

    @GetMapping("userWithdrawal")
    public String userWithdrawal() {


        return "/content/member/memberWithdrawal/user/userWithdrawal";

    }


    @PostMapping(value = "sendEmail", produces = "application/json; charset=utf-8")
    @ResponseBody
    public int sendEmail(@RequestBody String email){


        System.out.println("=========email:"+email);
        int result = memberService.sendEmail(email);

        return result;
    }

    @PostMapping(value = "checkEmailDuplication", produces = "application/json; charset=utf-8")

    public ResponseEntity<?> checkEmailDuplication(@RequestBody MemberDTO memberDTO) {

        boolean isUnique = memberService.checkEmailDuplication(memberDTO.getEmail());
        return ResponseEntity.ok(isUnique);
    }
    @PostMapping(value = "checkMail", produces = "application/json; charset=utf-8")
    @ResponseBody
    public boolean checkMail(@RequestBody Map<String, String> requestBody) {
        String checkMail = requestBody.get("emailCode");

        if (checkMail == null || checkMail.isEmpty()) {
            // 예외 처리: 이메일 코드가 없는 경우
            return false;
        }

        boolean isMatch = memberService.checkMail(checkMail);

        if (isMatch) {
            System.out.println("입력한 값과 데이터베이스 값이 일치합니다.");
        } else {
            System.out.println("입력한 값과 데이터베이스 값이 일치하지 않습니다.");
        }

        return isMatch;
    }





}
