package com.vision.transactionmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vision.transactionmanagement.entity.OrderInfo;

public interface OrderRepo extends JpaRepository<OrderInfo, Integer> {
}
