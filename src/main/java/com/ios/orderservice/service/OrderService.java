package com.ios.orderservice.service;

import com.ios.orderservice.dto.OrderRequest;

public interface OrderService {
	public void placeOrder(OrderRequest orderRequest);
}
