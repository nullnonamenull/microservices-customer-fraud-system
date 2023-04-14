package com.poleszak.apigateway.config;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@Component
public class ApiAuthorizationFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        Route route = exchange.getAttribute(GATEWAY_ROUTE_ATTR);
        if (route == null) {
            throw new ResponseStatusException(UNAUTHORIZED);
        }
        var application = route.getId();
        var apiKey = exchange.getRequest().getHeaders().get("ApiKey");

        if (apiKey == null || apiKey.isEmpty()) {
            throw new ResponseStatusException(UNAUTHORIZED);
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return LOWEST_PRECEDENCE;
    }
}
