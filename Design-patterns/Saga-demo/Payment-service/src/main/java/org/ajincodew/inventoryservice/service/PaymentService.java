package org.ajincodew.inventoryservice.service;

import java.util.HashMap;
import java.util.Map;

import org.ajincodew.inventoryservice.dto.PaymentRequestDTO;
import org.ajincodew.inventoryservice.dto.PaymentResponseDTO;
import org.ajincodew.inventoryservice.dto.PaymentStatus;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


@Service
public class PaymentService {

	private Map<Integer, Double> paymentMap;

	@PostConstruct
	private void init() {
		paymentMap = new HashMap<>();

		paymentMap.put(1, 500d);
		paymentMap.put(2, 1000d);
		paymentMap.put(3, 700d);
	}
	
	public PaymentResponseDTO debit(PaymentRequestDTO requestDTO) {
		double balance = paymentMap.getOrDefault(requestDTO.getUserId(), 0d);
		
		PaymentResponseDTO responseDTO = new PaymentResponseDTO();
		responseDTO.setOrderId(requestDTO.getOrderId());
		responseDTO.setUserId(requestDTO.getUserId());
		responseDTO.setAmount(requestDTO.getAmount());
		responseDTO.setStatus(PaymentStatus.PAYMENT_REJECTED);
		
		System.out.println("Inside Payment::"+balance);
		
		if (balance >= requestDTO.getAmount()) {
			responseDTO.setStatus(PaymentStatus.PAYMENT_APPROVED);
			paymentMap.put(requestDTO.getUserId(), balance - requestDTO.getAmount());
		}
		
		return responseDTO;
	}
	
	public void credit(PaymentRequestDTO requestDTO) {
		paymentMap.computeIfPresent(requestDTO.getUserId(), (k, v) -> v + requestDTO.getAmount());
	}
}
