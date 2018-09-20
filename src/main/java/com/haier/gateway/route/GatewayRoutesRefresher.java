package com.haier.gateway.route;

import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * 网关路由刷新.
 *
 * @author zhaojun
 */
@Component
public class GatewayRoutesRefresher implements ApplicationEventPublisherAware {

  ApplicationEventPublisher publisher;

  @Override
  public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
    publisher = applicationEventPublisher;
  }

  /**
   * 发布RefreshRoutesEvent事件,spring-cloud-gateway通过事件监听ApplicationListener<RefreshRoutesEvent>进行路由刷新.
   */
  public void refreshRoutes() {
    publisher.publishEvent(new RefreshRoutesEvent(this));
  }
}
