package com.dianping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(exposeProxy = true)
@SpringBootApplication
public class DemoDianPingApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoDianPingApplication.class, args);
    }

}
