package com.andresmromero.br.bo.customer.packager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.andresmromero.br.bo.customer.*")
@EntityScan(basePackages = "com.andresmromero.br.bo.customer.*")
@SpringBootApplication(scanBasePackages = "com.andresmromero.br.bo.customer.*")
public class CustomerPackagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(
                CustomerPackagerApplication.class,
                args);
    }
}