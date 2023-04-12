package com.example.eureka_server_13000;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServer13000Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer13000Application.class, args);
    }

}
