package com.wintech.wtapigateway.config;

import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class GatewaySecurityConfig {

//    private static final String[] PUBLIC = { "/wt-oauth/oauth/token" };
//
//    private static final String[] OPERATOR = { "" };
//
//    private static final String[] ADMIN = {
//            "/actuator/**",
//            "/wt-user/**",
//            "/wt-oauth/actuator/**"
//    };
//
//    private static final String[] SUPERVISOR = { "" };
//
//    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http){
//        return http
//                .authorizeExchange(exchange -> exchange
//                    .pathMatchers(PUBLIC)
//                        .permitAll()
//                    .pathMatchers(HttpMethod.GET, OPERATOR)
//                        .hasAnyRole("OPERATOR", "ADMIN")
//                    .pathMatchers(ADMIN)
//                        .hasAnyRole("ADMIN")
//                        .pathMatchers(SUPERVISOR)
//                        .hasRole("SUPERVISOR")
//                    .anyExchange()
//                        .authenticated()
//                )
//                .build();
//    }
}
