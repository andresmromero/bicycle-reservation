package com.andresmromero.br.bo.station.packager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableDiscoveryClient
@EnableJpaRepositories(basePackages = "com.andresmromero.br.bo.station.*")
@EntityScan(basePackages = "com.andresmromero.br.bo.station.*")
@SpringBootApplication(scanBasePackages = "com.andresmromero.br.bo.station.*")
public class StationPackagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(
                StationPackagerApplication.class,
                args);
    }
}