package com.haier.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * 限流Filter测试.
 *
 * @author zhaojun
 */
@RestController
@RequestMapping(value = "/request_rate_limiter")
public class RequestRateLimiterController {

  @GetMapping
  public Mono<String> nolimit() {
    return Mono.just("未达到限制条件");
  }

}
