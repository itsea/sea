package com.taotaole.tws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class TwsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwsApplication.class, args);
    }

}
