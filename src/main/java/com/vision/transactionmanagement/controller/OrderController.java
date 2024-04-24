package com.vision.transactionmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vision.transactionmanagement.dto.OrderAck;
import com.vision.transactionmanagement.dto.OrderRequest;
import com.vision.transactionmanagement.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController {

   @Autowired
   private OrderService orderService;
   
   @PostMapping("/orders")
   public ResponseEntity<OrderAck>  placeOrder(@RequestBody OrderRequest orderRequest){
	   try {
		   OrderAck orderAck= orderService.placingOrder(orderRequest);
		   return ResponseEntity.ok().body(orderAck);
	   }
	   catch (Exception e) {
		   OrderAck ack =new OrderAck();
		   ack.setStatus(e.getMessage());
		   return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(ack);  
	   }
   }
   
   @GetMapping("/orders/{id}")
   public ResponseEntity<OrderAck> getOrderById(@PathVariable (name ="id") int id){
	   return ResponseEntity.ok().body(orderService.getOrderById(id));
   }

}
