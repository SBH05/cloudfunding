package com.ohgiraffers.semiproject.delivery.model.dto;

import com.ohgiraffers.semiproject.member.model.dto.MemberDTO;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class TotalDeliveryDTO2 {
    private MemberDTO memberDTO;
    private CartDTO cartDTO;
    private DeliveryDTO deliveryDTO;
    private PaymentDTO paymentDTO;
    private PaymentHistoryDTO paymentHistoryDTO;
    private ProjectDTO projectDTO;
    private List<ProjectFileDTO> projectFileDTO;
    private ReturnHistoryDTO returnHistoryDTO;
    private ProjectOptionDTO projectOptionDTO;
    private BusinessMakeDTO businessMakeDTO;
}
