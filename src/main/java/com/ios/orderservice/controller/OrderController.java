package com.ios.orderservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ios.orderservice.dto.OrderRequest;
import com.ios.orderservice.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;

//   http://localhost:9092/api/order/placeorder	
	@PostMapping("/placeorder")
	@ResponseStatus(value = HttpStatus.CREATED)
	public String placeOrder(@RequestBody OrderRequest orderRequest) {

		orderService.placeOrder(orderRequest);
		return "Order Placed Successfully..!";
	}
}
