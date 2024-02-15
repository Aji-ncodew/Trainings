package org.ajincodew.orderservice.service;

import org.ajincodew.orderservice.dto.OrchestratorResponseDTO;
import org.ajincodew.orderservice.repo.PurchaseOrderRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import reactor.core.publisher.Mono;

@Service
public class UpdateService {

    @Autowired
    private PurchaseOrderRespository repo;

    public Mono<Void> updateOrder(OrchestratorResponseDTO responseDTO) {
        System.out.println("Response::"+responseDTO.getStatus());

        return repo.findById(responseDTO.getOrderId())
                .doOnNext(p -> p.setStatus(responseDTO.getStatus()))
                .doOnNext(repo::save)
                .then();
    }
}