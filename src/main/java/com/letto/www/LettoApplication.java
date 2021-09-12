package com.letto.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class LettoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LettoApplication.class, args);
    }

}
