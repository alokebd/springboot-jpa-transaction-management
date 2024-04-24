package com.vision.transactionmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vision.transactionmanagement.entity.PaymentInfo;

public interface PaymentRepo extends JpaRepository<PaymentInfo , Integer> {
}
