package com.tt;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceTestaApplication {

    public static void main(String[] args) {
//        SpringApplication.run(ServiceTestaApplication.class, args);
        System.setProperty("nepxion.banner.shown.ansi.mode","true");
        new SpringApplicationBuilder(ServiceTestaApplication.class).run(args);
    }


}
