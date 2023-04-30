package com.andresmromero.br.bo.pay.packager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.andresmromero.br.bo.pay.*")
@EntityScan(basePackages = "com.andresmromero.br.bo.pay.*")
@SpringBootApplication(scanBasePackages = "com.andresmromero.br.bo.pay.*")
public class PayPackagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(
                PayPackagerApplication.class,
                args);
    }
}