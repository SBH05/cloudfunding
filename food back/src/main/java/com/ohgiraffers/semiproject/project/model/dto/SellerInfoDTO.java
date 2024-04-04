package com.ohgiraffers.semiproject.project.model.dto;

import com.ohgiraffers.semiproject.member.model.dto.MemberDTO;

public class SellerInfoDTO {


    private MemberDTO seller;

    public SellerInfoDTO(MemberDTO seller) {
        this.seller = seller;
    }

    public MemberDTO getSeller() {
        return seller;
    }

    public void setSeller(MemberDTO seller) {
        this.seller = seller;
    }

    @Override
    public String toString() {
        return "SellerInfoDTO{" +
                "seller=" + seller +
                '}';
    }
}
