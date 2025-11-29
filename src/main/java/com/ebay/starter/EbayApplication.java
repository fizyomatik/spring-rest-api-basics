package com.ebay.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.ebay"})
@SpringBootApplication
public class EbayApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbayApplication.class, args);
    }

}
