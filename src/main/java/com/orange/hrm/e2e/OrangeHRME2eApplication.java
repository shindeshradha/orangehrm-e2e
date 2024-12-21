package com.orange.hrm.e2e;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrangeHRME2eApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrangeHRME2eApplication.class, args);
    }
}
