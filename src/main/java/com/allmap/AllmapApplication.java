package com.allmap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class AllmapApplication {

    public static void main(String[] args) {
        SpringApplication.run(AllmapApplication.class, args);
    }

}
