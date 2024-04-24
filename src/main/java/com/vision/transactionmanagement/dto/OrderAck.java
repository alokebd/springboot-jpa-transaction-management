package com.vision.transactionmanagement.dto;

import com.vision.transactionmanagement.entity.PaymentInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderAck {

    private String status;

    private double payabaleAmount;

    private PaymentInfo paymentInfo;
}
