package com.haier.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.GatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * 权限校验过滤器示例.
 *
 * @author zhaojun
 */
@Slf4j
@Component
public class AuthCheckGatewayFilterFactory implements GatewayFilterFactory {

  @Override
  public GatewayFilter apply(Object config) {
    return (exchange, chain) -> {
      /*
        获取authToken验证,这里是从参数获取,也可以从header获取.
        或者是调用鉴权服务
       */
      String token = exchange.getRequest().getQueryParams().getFirst("authToken");
      if (token == null || token.isEmpty()) {
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        return exchange.getResponse().setComplete();
      }
      return chain.filter(exchange);
    };
  }

  @Override
  public Object newConfig() {
    return new Object();
  }
}