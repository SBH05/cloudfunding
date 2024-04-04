package com.ohgiraffers.semiproject.config.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import java.io.IOException;
import java.net.URLEncoder;

@Configuration
public class AuthFailHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        // 응답할 오류 메세지를 저장하기 위해 선언
        String errorMessage;
        if(exception instanceof BadCredentialsException){ // BadCredentialsException 오류는 사용자의 아이디가 DB에 존재하지 않거나 비밀번호가 잘못된 경우 발생한다.
            errorMessage = "아이디가 존재하지 않거나 비밀번호가 일치하지 않습니다.";
        } else if (exception instanceof InternalAuthenticationServiceException) { // 서버가 사용자 정보를 검증하는 과정에서 발생할 수 있는 오류이다.
            errorMessage = "서버에서 오류가 발생되었습니다. \n 관리자에게 문의해주세요";
        } else if (exception instanceof UsernameNotFoundException) { // 사용자 아이디 정보를 찾을 수 없을때 발생할 수 있는 에러이다.
            errorMessage = "존재하지 않는 이메일 입니다. \n 이메일을 확인해주세요";
        } else if (exception instanceof AuthenticationCredentialsNotFoundException) {
            // 보안 컨텍스트에 인증 객체가 존재하지 않거나 인증 정보가 없는 상태에서 보안처리된 리소스에 접근하는 경우 발생
            errorMessage = "인증 요청이 거부되었습니다. \n 관리자에게 문의해주세요";
        }else{
            errorMessage =  "알 수 없는 오류로 로그인 요청을 처리할 수 없습니다. \n 관리자에게 문의해주세요";
        }

        //URL을 안전하게 인코딩 하는데 사용되는 유틸로 문자열을 URL에 사용가능한 형식으로 인코딩할 수 있다.
        errorMessage = URLEncoder.encode(errorMessage,"UTF-8");

        //오류를 처리할 페이지로 이동시킨다. URL 요청은 servlet에 정의해야함.
        setDefaultFailureUrl("/auth/fail?message="+errorMessage);
        
        // 부모에 메서드를 호출하여 다음 로직을 수행하도록 하기 위함이다.
        super.onAuthenticationFailure(request,response,exception);
    }
}
