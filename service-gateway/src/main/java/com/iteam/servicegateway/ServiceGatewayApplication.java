package com.iteam.servicegateway;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceGatewayApplication {
	
	@Bean
	RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes().route(r -> r.path("/api/product/**").uri("http://localhost:8082")).build();
	}

	// @Bean
	// RouteLocator routes(RouteLocatorBuilder builder) {
	// return builder.routes().route(r ->
	// r.path("/api/product/**").uri("lb://PRODUCT-SERVICE")).build();
	// }

	@Bean
	public DiscoveryClientRouteDefinitionLocator dynamicRoutes(ReactiveDiscoveryClient rdc,
			DiscoveryLocatorProperties dlp) {
		return new DiscoveryClientRouteDefinitionLocator(rdc, dlp);
	}

	public static void main(String[] args) {
		SpringApplication.run(ServiceGatewayApplication.class, args);
	}

}
