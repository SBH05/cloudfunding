package com.ohgiraffers.semiproject.member.model.service;


import com.ohgiraffers.semiproject.member.model.dao.MemberMapper;
import com.ohgiraffers.semiproject.member.model.dto.MemberAndAuthorityDTO;
import com.ohgiraffers.semiproject.member.model.dto.MemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthenticationService implements UserDetailsService {

    private final MemberMapper mapper;

    public AuthenticationService(MemberMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        log.info("");
        log.info("");
        log.info("[AuthenticationService] ===================================================== start");
        log.info("[AuthenticationService] userId : " + userId);

        MemberAndAuthorityDTO member = mapper.findByMemberId(userId);
        log.info("[AuthenticationService] member : " + member);

        if(member == null){
            throw new UsernameNotFoundException("회원 정보가 존재하지 않습니다");
        }
        log.info("[AuthenticationService] ===================================================== end");
        return member;
    }

}
