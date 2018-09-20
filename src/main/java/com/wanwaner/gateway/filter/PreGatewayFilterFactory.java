package com.wanwaner.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

/**
 * 前置网关过滤器示例.
 *
 * @author zhaojun
 */
@Component
public class PreGatewayFilterFactory extends AbstractGatewayFilterFactory<PreGatewayFilterFactory.Config> {

  public PreGatewayFilterFactory() {
    super(Config.class);
  }

  @Override
  public GatewayFilter apply(Config config) {
    // 获取配置.
    return (exchange, chain) -> {
      //前置filter.
      ServerHttpRequest.Builder builder = exchange.getRequest().mutate();
      return chain.filter(exchange.mutate().request(builder.build()).build());
    };
  }

  public static class Config {
    //配置.
  }

}