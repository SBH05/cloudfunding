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
public class QnAAnswerDTO {

    private int answerCode;

     private String answer;

     private QnAhistoryDTO creationNumber;

     private Date answerDay;

}
