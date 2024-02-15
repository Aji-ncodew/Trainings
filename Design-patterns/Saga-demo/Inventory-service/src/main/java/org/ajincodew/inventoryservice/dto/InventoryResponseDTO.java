package org.ajincodew.inventoryservice.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class InventoryResponseDTO {
	private Integer userId;

	private Integer productId;

	private UUID orderId;

	private InventoryStatus status;

}
