package com.andresmromero.br.bo.reservation.packager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableDiscoveryClient
@EnableJpaRepositories(basePackages = "com.andresmromero.br.bo.reservation.*")
@EntityScan(basePackages = "com.andresmromero.br.bo.reservation.*")
@SpringBootApplication(scanBasePackages = "com.andresmromero.br.bo.reservation.*")
@EnableFeignClients(basePackages = "com.andresmromero.br.bo.reservation.*")
public class ReservationPackagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(
                ReservationPackagerApplication.class,
                args);
    }
}