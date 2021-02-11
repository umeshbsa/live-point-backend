package com.app.livepoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("com.app.livepoint")
@SpringBootApplication
public class LivepointApplication {

    public static void main(String[] args) {
        SpringApplication.run(LivepointApplication.class, args);
        System.out.println("Hello");
    }
}


