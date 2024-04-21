package com.iteam.servicegateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class ServiceGatewayApplication {
	// @Bean
	// RouteLocator routes(RouteLocatorBuilder builder) {
	// 	return builder.routes().route(r -> r.path("/societes/**").uri("http://localhost:8081")).build();
	// }
	// @Bean
	// RouteLocator routes(RouteLocatorBuilder builder) {
	// return builder.routes().route(r ->
	// r.path("/societes/**").uri("lb://SERVICE-SOCIETE")).build();
	// }

	@Bean
	DiscoveryClientRouteDefinitionLocator dynamicRoutes(ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties dlp) {
		return new DiscoveryClientRouteDefinitionLocator(rdc, dlp);
	}

	public static void main(String[] args) {
		SpringApplication.run(ServiceGatewayApplication.class, args);
	}

}
