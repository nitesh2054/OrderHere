package com.nitesh.orderhere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class OrderHereApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderHereApplication.class, args);
    }

}
