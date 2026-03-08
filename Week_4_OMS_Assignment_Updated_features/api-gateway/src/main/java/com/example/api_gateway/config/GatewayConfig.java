package com.example.api_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder){

        return builder.routes()

                .route("order-service", r -> r
                        .path("/orders/**")
                        .uri("lb://ORDER-SERVICE"))

                .route("analytics-service", r -> r
                        .path("/analytics/**")
                        .uri("lb://ANALYTICS-SERVICE"))

                .route("auth-service", r -> r
                        .path("/auth/**")
                        .uri("lb://AUTH-SERVICE"))

                .build();
    }

}
