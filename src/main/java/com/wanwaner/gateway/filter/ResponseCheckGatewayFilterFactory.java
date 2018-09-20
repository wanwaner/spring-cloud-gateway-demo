package com.wanwaner.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.GatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * 一个自定义默认网关过滤器示例.
 *
 * @author zhaojun
 */
@Slf4j
@Component
public class ResponseCheckGatewayFilterFactory implements GatewayFilterFactory {

  @Override
  public GatewayFilter apply(Object config) {
    return (exchange, chain) -> {
      log.info("请求开始");
      return chain.filter(exchange).then(Mono.fromRunnable((Runnable) () -> {
        if (!exchange.getResponse().isCommitted()) {
          log.info("成功获取到响应。");
          log.info("响应结果：{}", exchange.getResponse());
        } else {
          log.info("未成功获取到响应。");
        }
      }));
    };
  }

  @Override
  public Object newConfig() {
    return new Object();
  }
}