package com.one.portfoilo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.one.portfoilo")
public class PortfoiloApplication {

    public static void main(String[] args) {
        SpringApplication.run(PortfoiloApplication.class, args);
    }

}
