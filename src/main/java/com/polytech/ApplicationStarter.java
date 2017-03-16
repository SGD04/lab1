package com.polytech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Sergio on 16/03/2017.
 */
@SpringBootApplication
public class ApplicationStarter {

    public static  void  main(String[] args){
        System.setProperty("spring.profiles.active","PROD");
        SpringApplication.run(ApplicationStarter.class);
    }
}
