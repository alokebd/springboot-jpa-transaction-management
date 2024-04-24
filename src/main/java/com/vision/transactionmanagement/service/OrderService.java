package com.vision.transactionmanagement.service;

import static com.vision.transactionmanagement.util.PaymentValidation.validatePaymentInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vision.transactionmanagement.dto.OrderAck;
import com.vision.transactionmanagement.dto.OrderRequest;
import com.vision.transactionmanagement.entity.OrderInfo;
import com.vision.transactionmanagement.entity.PaymentInfo;
import com.vision.transactionmanagement.repo.OrderRepo;
import com.vision.transactionmanagement.repo.PaymentRepo;

@Service
public class OrderService {

    @Autowired

    private OrderRepo orderRepo;

    @Autowired
    private PaymentRepo paymentRepo;

    @Transactional
    public OrderAck placingOrder(OrderRequest orderRequest){
        OrderInfo   orderInfo = orderRequest.getOrderInfo();
        orderInfo  = orderRepo.save(orderInfo);

        PaymentInfo paymentInfo = orderRequest.getPaymentInfo();
  
        validatePaymentInfo(paymentInfo);
    
        orderInfo.setProductName(paymentInfo.getProductName());
     
        orderRepo.save(orderInfo);

        paymentRepo.save(paymentInfo);
    
        return new OrderAck("Success",paymentInfo.getAmount(),paymentInfo);
    }
    
    public OrderAck getOrderById(int orderId) {
    	OrderInfo order =orderRepo.findById(orderId).get();
    	PaymentInfo payment = paymentRepo.findById(orderId).get();
    	OrderAck ack = new OrderAck();
    	ack.setStatus(order.getOrderStatus());
    	ack.setPayabaleAmount(payment.getAmount());
    	ack.setPaymentInfo(payment);
    	return ack;
    }


}
