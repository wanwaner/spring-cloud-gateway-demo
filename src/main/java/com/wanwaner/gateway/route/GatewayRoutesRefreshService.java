package com.wanwaner.gateway.route;

import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

/**
 * 网关路由刷新服务.
 *
 * @author zhaojun
 */
@Service
public class GatewayRoutesRefreshService {

  @Autowired
  private RouteDefinitionWriter routeDefinitionWriter;

  @Autowired
  private GatewayRoutesRefresher gatewayRoutesRefresher;

  public String save() {
    RouteDefinition definition = new RouteDefinition();
    PredicateDefinition predicate = new PredicateDefinition();
    Map<String, String> predicateParams = new HashMap<>(16);

    definition.setId("baiduRoute");
    predicate.setName("Path");
    predicateParams.put("pattern", "/baidu");
    predicateParams.put("pathPattern", "/baidu");
    predicate.setArgs(predicateParams);
    definition.setPredicates(Collections.singletonList(predicate));
    URI uri = UriComponentsBuilder.fromHttpUrl("http://www.baidu.com").build().toUri();
    definition.setUri(uri);
    routeDefinitionWriter.save(Mono.just(definition)).subscribe();
    gatewayRoutesRefresher.refreshRoutes();
    return "success";
  }

}
