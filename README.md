| 组件 | 功能 | 备注|
| ---- | ----| ---- |
| Eureka | 服务注册中心 | 内嵌了Ribbon依赖，所以支持负载均衡 |
| Zookeeper | 服务注册中心 | |
| Consul | 服务注册中心 | |
| Nacos | 服务注册中心，服务配置，服务总线 | |
| Ribbon  LoadBalancer | 服务调用 | 结合RestTemplate（http调用）使用,实现负载均衡|
| OpenFeign| 服务调用 | 取代RestTemplate + Ribbon 以实现面向接口开发 |
| Hystrix | 服务降级，服务熔断，服务限流 ||

