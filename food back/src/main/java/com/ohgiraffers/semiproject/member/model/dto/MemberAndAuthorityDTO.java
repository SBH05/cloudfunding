package com.ohgiraffers.semiproject.member.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class MemberAndAuthorityDTO implements UserDetails {

    private MemberDTO memberDTO;
    private AuthorityDTO authorityDTO;

    public MemberAndAuthorityDTO() {
    }

    public MemberAndAuthorityDTO(MemberDTO memberDTO, AuthorityDTO authorityDTO) {
        this.memberDTO = memberDTO;
        this.authorityDTO = authorityDTO;
    }

    public MemberDTO getMemberDTO() {
        return memberDTO;
    }

    public void setMemberDTO(MemberDTO memberDTO) {
        this.memberDTO = memberDTO;
    }

    public AuthorityDTO getAuthorityDTO() {
        return authorityDTO;
    }

    public void setAuthorityDTO(AuthorityDTO authorityDTO) {
        this.authorityDTO = authorityDTO;
    }



    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<GrantedAuthority> roles = new HashSet<>();
        for (String role : authorityDTO.getAuthorityName().split(",")){
            roles.add(new SimpleGrantedAuthority(role));
        }
        return roles;
    }

    @Override
    public String getPassword() {
        return memberDTO.getUserPwd();
    }
    public int getUserCode() {
        return memberDTO.getUserCode();
    }

    @Override
    public String getUsername() {
        return memberDTO.getUserId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "MemberAndAuthorityDTO{" +
                "memberDTO=" + memberDTO +
                ", authorityDTO=" + authorityDTO +
                '}';
    }
}

