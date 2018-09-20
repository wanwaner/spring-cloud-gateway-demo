package com.wanwaner.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * After Route Predicate & Before Route Predicate & Between Route Predicate测试.
 *
 * @author zhaojun
 */
@RestController
@RequestMapping(value = "/after_or_before_or_between")
public class AfterOrBeforeOrBetweenController {

  @GetMapping("/after")
  public Mono<String> after() {
    return Mono.just("after");
  }

  @GetMapping("/before")
  public Mono<String> before() {
    return Mono.just("before");
  }

  @GetMapping("/between")
  public Mono<String> between() {
    return Mono.just("between");
  }
}
