package com.example.gateway;

import com.example.gateway.filter.CustomGatewayFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }


    /**
     * 基本的转发
     * 当访问http://localhost:8080/jd
     * 转发到http://jd.com
     * @param builder
     * @return
     */
  /*  @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                //basic proxy
                .route(r ->
                        r.path("/jd")
                        .uri("http://jd.com:80/")
                        .id("jd_route")
                ).build();
    }*/

   /* @Bean
    public RouteLocator customRouteLocator2(RouteLocatorBuilder builder) {
        //生成比当前时间早一个小时的UTC时间
        ZonedDateTime minusTime = LocalDateTime.now().minusHours(1).atZone(ZoneId.systemDefault());
        return builder.routes()
            .route("after_route", r -> r.after(minusTime)
                    .uri("http://baidu.com"))
            .build();
    }*/

/*    @Bean
    public RouteLocator customRouteLocator3(RouteLocatorBuilder builder) {
        //生成比当前时间早一个小时的UTC时间

        ZonedDateTime minusTime = LocalDateTime.now().plusHours(48).atZone(ZoneId.systemDefault());
        return builder.routes()
            .route("after_route", r -> r.after(minusTime)
                    .uri("http://baidu.com"))
            .build();
    }*/
/*
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("cookie_route", r -> r.cookie("ttt", "PPP")
                        .uri("http://localhost:8082/test/cookie"))
                .build();
    }*/

   /* @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("header_route", r -> r.header("token", "Gloring")
                        .uri("http://localhost:8082/test/cookie"))
                .build();
    }*/

   /* @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("host_route", r -> r.host("**.baidu.com:5001")
                        .uri("http://jd.com"))
                .build();
    }*/

   /* @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("method_route", r -> r.method("GET")
                    .uri("http://jd.com"))
            .build();
    }*/

   /* @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("query_route", r -> r.query("token","Glorings")
                        .uri("http://baidu.com"))
                .build();
    }*/

    /*@Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("remoteaddr_route", r -> r.remoteAddr("127.0.0.1")
                    .uri("http://baidu.com"))
            .build();
    }*/

   /* @Bean
    public RouteLocator testRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("add_request_header_route", r ->
                        r.path("/test").filters(f -> f.addRequestHeader("X-Request-Acme", "ValueB"))
                                .uri("http://localhost:8082/test/head"))
                .build();
    }*/

   /* @Bean
    public RouteLocator testRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("add_request_parameter_route", r ->
                        r.path("/addRequestParameter").filters(f -> f.addRequestParameter("example", "ValueB"))
                                .uri("http://localhost:8082/test/addRequestParameter"))
                .build();
    }*/


   /* @Bean
    public RouteLocator testRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("rewritepath_route", r ->
                        r.path("/foo/**").filters(f -> f.rewritePath("/foo/(?<segment>.*)","/$\\{segment}"))
                                .uri("http://www.baidu.com"))
                .build();
    }*/

  /*  @Bean
    public RouteLocator testRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("add_request_header_route", r ->
                        r.path("/test").filters(f -> f.addResponseHeader("X-Response-Foo", "Bar"))
                                .uri("http://www.baidu.com"))
                .build();
    }*/

    @Bean
    public RouteLocator retryRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("retry_route", r -> r.path("/test/retry")
                    .filters(f ->f.retry(config -> config.setRetries(2).setStatuses(HttpStatus.INTERNAL_SERVER_ERROR)))
                    .uri("http://localhost:8082/retry?key=abc&count=5"))
            .build();
    }

    //自定义GatewayFilter
  /*  @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/test")
                        .filters(f -> f.filter(new CustomGatewayFilter()))
                        .uri("http://localhost:8082/customFilter?name=Glorings")
                        .order(0)
                        .id("custom_filter")
                )
                .build();
    }*/
}
