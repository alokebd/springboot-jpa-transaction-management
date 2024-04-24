package com.vision.transactionmanagement.dto;

import com.vision.transactionmanagement.entity.OrderInfo;
import com.vision.transactionmanagement.entity.PaymentInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderRequest {

    private OrderInfo orderInfo ;

    private PaymentInfo paymentInfo ;
}
