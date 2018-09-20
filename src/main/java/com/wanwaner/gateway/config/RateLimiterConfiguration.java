

package com.wanwaner.gateway.config;

import java.util.Objects;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * 限流器配置.
 *
 * @author zhaojun
 */
@Configuration
public class RateLimiterConfiguration {

  /**
   * 根据IP限流Resolver.
   */
  @Bean(value = "ipKeyResolver")
  public KeyResolver ipKeyResolver() {
    return exchange -> Mono
        .just(Objects.requireNonNull(exchange.getRequest().getRemoteAddress()).getAddress().getHostAddress());
  }

  /**
   * 根据用户id限流Resolver.
   */
  @Bean(value = "userIdResolver")
  public KeyResolver userIdResolver() {
    return exchange -> Mono.just(Objects.requireNonNull(exchange.getRequest().getQueryParams().getFirst("userId")));
  }

  /**
   * 根据path限流Resolver.
   */
  @Bean(value = "apiKeyResolver")
  public KeyResolver apiKeyResolver() {
    return exchange -> Mono.just(exchange.getRequest().getPath().value());
  }

}
