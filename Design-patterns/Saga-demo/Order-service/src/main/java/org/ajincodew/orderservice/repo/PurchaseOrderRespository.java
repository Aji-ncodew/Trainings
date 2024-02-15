package org.ajincodew.orderservice.repo;

import java.util.UUID;

import org.ajincodew.orderservice.entity.PurchaseOrder;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrderRespository extends ReactiveCrudRepository<PurchaseOrder, UUID> {

}
