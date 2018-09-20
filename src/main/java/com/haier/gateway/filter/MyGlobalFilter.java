package com.haier.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 全局filter-demo.
 *
 * @author zhaojun
 */
@Slf4j
@Component
public class MyGlobalFilter implements GlobalFilter, Ordered {

  @Override
  public int getOrder() {
    return -100;
  }

  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    log.info("这里是一个全局过滤器,你可以在这里修改请求上下文");
    return chain.filter(exchange);
  }
}
