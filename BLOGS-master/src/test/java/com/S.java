package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;


@SpringBootApplication
@Component
public class S {
    public static void main(String[] args) {
        SpringApplication.run(S.class,args);
    }
}
