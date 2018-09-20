package com.haier.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * 自定义Filter测试.
 *
 * @author zhaojun
 */
@RestController
@RequestMapping(value = "/filter")
public class AuthCheckFilterController {

  @GetMapping("/auth")
  public Mono<String> filter1() {
    return Mono.just("auth");
  }

}
