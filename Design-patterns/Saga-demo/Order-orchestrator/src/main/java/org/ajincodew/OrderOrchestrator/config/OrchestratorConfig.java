package org.ajincodew.OrderOrchestrator.config;


import org.ajincodew.OrderOrchestrator.common.OrchestratorRequestDTO;
import org.ajincodew.OrderOrchestrator.common.OrchestratorResponseDTO;
import org.ajincodew.OrderOrchestrator.service.OrchestratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.function.Function;


@Configuration
public class OrchestratorConfig {

	@Autowired
	private OrchestratorService orchestratorService;

	@Bean
	public Function<Flux<OrchestratorRequestDTO>, Flux<OrchestratorResponseDTO>> processor() {
		return flux -> flux.flatMap(dto -> orchestratorService.orderProduct(dto))
				.doOnNext(dto -> System.out.println("Status : " + dto.getStatus()));
	}

}
