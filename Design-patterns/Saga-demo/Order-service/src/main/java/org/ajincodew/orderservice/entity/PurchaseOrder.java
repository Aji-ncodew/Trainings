package org.ajincodew.orderservice.entity;

import java.util.UUID;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.ajincodew.orderservice.dto.OrderStatus;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@ToString
public class PurchaseOrder {
	@Id
	private UUID id;
	private Integer userId;
	private Integer productId;
	private Double price;
	private OrderStatus status;

}