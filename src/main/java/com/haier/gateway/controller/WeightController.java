package com.haier.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * 权重路由规则测试.
 *
 * @author zhaojun
 */
@RestController
@RequestMapping(value = "/weight")
public class WeightController {

  @GetMapping("/v1")
  public Mono<String> v1() {
    return Mono.just("v1");
  }

  @GetMapping("/v2")
  public Mono<String> v2() {
    return Mono.just("v2");
  }
}
