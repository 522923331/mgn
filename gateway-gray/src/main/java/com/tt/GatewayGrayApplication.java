package com.tt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayGrayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayGrayApplication.class, args);
    }

}
