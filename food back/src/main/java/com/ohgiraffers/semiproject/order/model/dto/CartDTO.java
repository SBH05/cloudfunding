package com.ohgiraffers.semiproject.order.model.dto;

import com.ohgiraffers.semiproject.member.model.dto.MemberDTO;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class CartDTO {

    private int cartCode;

    private MemberDTO memberCode;

    private ProjectDTO  projectCode;

    private ProjectOptionDTO projectOptionCode;

    private String status;

    private int count;

}


