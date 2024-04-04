package com.ohgiraffers.semiproject.project.product.model.dto;

import com.ohgiraffers.semiproject.member.model.dto.MemberAndAuthorityDTO;
import com.ohgiraffers.semiproject.order.model.dto.CartDTO;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProjectOptionDTO {
    private int optionCode;
    private String optionName;
    private char optionType;
    private int price;
    private String configure;
    private int projectCode;
//    private CartDTO cart;

}
