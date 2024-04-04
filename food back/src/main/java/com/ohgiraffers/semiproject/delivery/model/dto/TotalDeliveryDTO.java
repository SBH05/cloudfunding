package com.ohgiraffers.semiproject.delivery.model.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class TotalDeliveryDTO {
    private CartDTO cartDTO;
    private DeliveryDTO deliveryDTO;
    private PaymentDTO paymentDTO;
    private PaymentHistoryDTO paymentHistoryDTO;
    private ProjectDTO projectDTO;
    private List<ProjectFileDTO> projectFileDTO;
    private ReturnHistoryDTO returnHistoryDTO;
}
