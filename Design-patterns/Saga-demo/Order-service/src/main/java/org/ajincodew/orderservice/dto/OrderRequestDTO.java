package org.ajincodew.orderservice.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderRequestDTO {
	private Integer userId;
	private Integer productId;
	private UUID orderId;
}