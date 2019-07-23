package com.arek.dbrepo.dbservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.arek.dbrepo.dbservice.repository")
@SpringBootApplication
public class DbserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbserviceApplication.class, args);
    }

}
