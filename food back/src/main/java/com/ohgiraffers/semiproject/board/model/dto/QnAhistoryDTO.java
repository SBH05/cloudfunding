package com.ohgiraffers.semiproject.board.model.dto;

import com.ohgiraffers.semiproject.member.model.dto.MemberDTO;
import com.ohgiraffers.semiproject.order.model.dto.ProjectDTO;
import lombok.*;

import java.sql.Date;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QnAhistoryDTO {

    private int number;

     private MemberDTO memberDTO;

     private String title;

     private String content;

     private int sellerCode;

     private Date creation;

}
