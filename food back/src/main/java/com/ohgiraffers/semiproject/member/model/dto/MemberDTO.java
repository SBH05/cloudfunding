package com.ohgiraffers.semiproject.member.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberDTO {

    private int userCode;
    private String userId;

    private String userPwd;

    private String email;

    private String address;

    private String userName;

    private String dateBirth;

    private String phone;

    private String activityStatus;

    private int reportCount;

    private String couponStatus;

    private java.util.Date registrationDate;
    private int emailCode;






}
