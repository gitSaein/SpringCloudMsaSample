package com.springcloud.gateway;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BoardGatewayFilterFactory extends AbstractGatewayFilterFactory<BoardGatewayFilterFactory.Config>{

	@Data
	public static class Config{
		private String baseMessage;
		private boolean preLogger;
		private boolean postLogger;
	}

	@Override
	public GatewayFilter apply(Config config) {
		// TODO Auto-generated method stub
		return ((exchange, chain)->{
			ServerHttpRequest request = exchange.getRequest();
			log.info(NAME_KEY);
			
			return chain.filter(exchange.mutate().request(request).build());
		});
	}
}
