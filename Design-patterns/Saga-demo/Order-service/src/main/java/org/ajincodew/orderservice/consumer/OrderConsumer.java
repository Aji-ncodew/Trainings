package org.ajincodew.orderservice.consumer;

import java.util.function.Consumer;
import java.util.function.Supplier;

import org.ajincodew.orderservice.dto.OrchestratorRequestDTO;
import org.ajincodew.orderservice.dto.OrchestratorResponseDTO;
import org.ajincodew.orderservice.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reactor.core.publisher.Flux;

@Configuration
public class OrderConsumer {

	@Autowired
	private Flux<OrchestratorRequestDTO> flux;

	@Autowired
	private UpdateService update;

	@Bean
	public Supplier<Flux<OrchestratorRequestDTO>> supplier() {
		return () -> flux;
	}

	@Bean
	public Consumer<Flux<OrchestratorResponseDTO>> consumer() {
		return c -> c
				.doOnNext(a -> System.out.println("Cosuming::" + a))
				.flatMap(responseDTO -> update.updateOrder(responseDTO))
				.subscribe();
	};

}