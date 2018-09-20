package com.haier.gateway.route;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.cloud.gateway.support.NotFoundException;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 自定义RouteDefinitionRepository,使用redis进行存储.
 *
 * @author zhaojun
 */
@Component
public class RedisRouteDefinitionRepository implements RouteDefinitionRepository {

  public static final String GATEWAY_ROUTES = "gateway_routes";

  @Autowired
  private StringRedisTemplate redisTemplate;

  @Override
  public Flux<RouteDefinition> getRouteDefinitions() {
    List<RouteDefinition> routeDefinitions = new ArrayList<>();
    redisTemplate.opsForHash().values(GATEWAY_ROUTES).forEach(routeDefinition -> {
      routeDefinitions.add(JSON.parseObject(routeDefinition.toString(), RouteDefinition.class));
    });
    return Flux.fromIterable(routeDefinitions);
  }

  @Override
  public Mono<Void> save(Mono<RouteDefinition> route) {
    return route
        .flatMap(routeDefinition -> {
          redisTemplate.opsForHash().put(GATEWAY_ROUTES, routeDefinition.getId(),
              JSON.toJSONString(routeDefinition));
          return Mono.empty();
        });
  }

  @Override
  public Mono<Void> delete(Mono<String> routeId) {
    return routeId.flatMap(id -> {
      if (redisTemplate.opsForHash().hasKey(GATEWAY_ROUTES, id)) {
        redisTemplate.opsForHash().delete(GATEWAY_ROUTES, id);
        return Mono.empty();
      }
      return Mono.defer(() -> Mono.error(new NotFoundException("RouteDefinition not found: " + routeId)));
    });
  }

}