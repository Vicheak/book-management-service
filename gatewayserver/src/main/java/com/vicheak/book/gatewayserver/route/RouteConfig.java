package com.vicheak.book.gatewayserver.route;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator routeLocatorConfig(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route("bookservice_book_route_" + UUID.randomUUID(), predicate ->
                        predicate.path("/bookservice/book/**")
                                .filters(filter ->
                                        filter.rewritePath("/bookservice/book/(?<segment>.*)",
                                                "/${segment}"))
                                .uri("lb://BOOK")
                )
                .route("bookservice_borrow_route_" + UUID.randomUUID(), predicate ->
                        predicate.path("/bookservice/borrow/**")
                                .filters(filter ->
                                        filter.rewritePath("/bookservice/borrow/(?<segment>.*)",
                                                "/${segment}"))
                                .uri("lb://BORROW")
                )
                .build();
    }

}
