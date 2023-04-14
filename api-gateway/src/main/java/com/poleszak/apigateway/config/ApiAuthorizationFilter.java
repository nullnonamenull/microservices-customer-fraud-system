package com.poleszak.apigateway.config;

import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class ApiAuthorizationFilter implements GlobalFilter, Ordered {

    private final FakeApiAuthorizationChecker fakeApiAuthorizationChecker;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        Route route = exchange.getAttribute(GATEWAY_ROUTE_ATTR);
        var application = route.getId();
        var apiKey = exchange.getRequest().getHeaders().get("ApiKey");

        if (application == null || (apiKey == null || apiKey.isEmpty()) || !fakeApiAuthorizationChecker.isAuthorized(apiKey.get(0), application)) {
            throw new ResponseStatusException(UNAUTHORIZED);
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return LOWEST_PRECEDENCE;
    }
}
