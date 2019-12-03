package com.dubbo.demo.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(value = {"classpath*:dubbo/dubbo-provider.xml"})
public class DubboDemoWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboDemoWebApplication.class, args);
    }

}
