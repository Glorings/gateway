package com.example.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class TestController {


    // 这里只举例获取服务方信息,不去请求服务方接口
    @GetMapping("/test")
    public String test(){
        String format = ZonedDateTime.now().minusHours(1).format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
        System.out.println(format);
        return "SUCCESS";
    }


}
