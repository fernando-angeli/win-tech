//package com.wintech.wtapigateway.config;
//
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class GatewayConfig {
//
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
//        return builder.routes()
//                .route("wt-user", r -> r.path("/wt-user/**")
//                        .uri("http://wt-user"))
//                .route("wt-oauth", r -> r.path("/wt-oauth/**")
//                        .uri("http://wt-oauth"))
//                .build();
//    }
//}
