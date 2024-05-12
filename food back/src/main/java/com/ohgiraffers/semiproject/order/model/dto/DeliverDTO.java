package com.ohgiraffers.semiproject.order.model.dto;
import com.ohgiraffers.semiproject.member.model.dto.MemberDTO;
import lombok.*;

import java.sql.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class DeliverDTO {

    private int deliverCode;

    private Date day;

    private String status;

    private MemberDTO memberCode;
    private String request;
    private String  purchase;
    private Date confirmDate;


}
