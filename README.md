# API Gateway - Spring-Cloud-Gateway实现.

## 1. spring-cloud-gateway 特征
* 基于Java8 / Spring 5 / SpringBoot2 / WebFlux / Reactor
* 动态路由
* Predicates 和 Filters 作用于特定路由
* 集成 Hystrix 断路器
* 集成 Spring Cloud DiscoveryClient
* 易于编写的 Predicates 和 Filters
* 限流
* 路径重写
## 2. VS  zuul1
Zuul1 基于 Servlet 2.5（使用 3.x），使用阻塞 API，它不支持任何长连接，如 WebSockets。而 Spring Cloud Gateway 建立在 Spring Framework 5，Project Reactor 和 Spring Boot 2 之上，使用非阻塞 API，支持 WebSockets，支持Http2,并且由于它与 Spring 紧密集成，所以将会是一个更好的开发体验.
## 3. demo 运行


说明：

* 限流以及动态路由的存储使用了redis中间件,需要在本地运行redis实例.
