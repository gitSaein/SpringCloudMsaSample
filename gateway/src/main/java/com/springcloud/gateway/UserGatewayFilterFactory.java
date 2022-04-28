package com.springcloud.gateway;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class UserGatewayFilterFactory extends AbstractGatewayFilterFactory<UserGatewayFilterFactory.Config>{
	
	public UserGatewayFilterFactory() {
		super(Config.class);
	}

	@Override
	public GatewayFilter apply(Config config) {
		// TODO Auto-generated method stub
		return (exchange, chain) ->{
			ServerHttpRequest request = exchange.getRequest();
			log.info(NAME_KEY);
			ServerHttpRequest.Builder builder = exchange.getRequest().mutate();
			
			return chain.filter(exchange.mutate().request(request).build());
		}; 
	}
	
	@Data
	public static class Config{
		private String baseMessage;
		private boolean preLogger;
		private boolean postLogger;
	}


}
