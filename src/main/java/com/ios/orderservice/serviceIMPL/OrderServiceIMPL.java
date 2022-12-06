package com.ios.orderservice.serviceIMPL;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ios.orderservice.dto.OrderLineItemsDto;
import com.ios.orderservice.dto.OrderRequest;
import com.ios.orderservice.model.Order;
import com.ios.orderservice.model.OrderLineItems;
import com.ios.orderservice.repository.OrderRepository;
import com.ios.orderservice.service.OrderService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceIMPL implements OrderService {

	private final OrderRepository orderRepository;

	@Override
	public void placeOrder(OrderRequest orderRequest) {

		log.info("*****ORDER REQUEST****** :{}", orderRequest);
		Order order = new Order();

		order.setOrderNumber(UUID.randomUUID().toString());

		List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList().stream()
				.map(ord -> mapToDto(ord)) .toList();

		order.setOrderLineItemsList(orderLineItems);
		log.info("*****ORDER***** :{}", order);
		orderRepository.save(order);
		log.info("*****ORDER SAVED***** :{}", order);

	}

	private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
		OrderLineItems orderLineItems = new OrderLineItems();
		orderLineItems.setPrice(orderLineItemsDto.getPrice());
		orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
		orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
		log.info("******OrderLineItems****** :{}", orderLineItems);
		return orderLineItems;
	}
}
