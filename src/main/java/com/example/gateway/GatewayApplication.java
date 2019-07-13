package com.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

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
}
