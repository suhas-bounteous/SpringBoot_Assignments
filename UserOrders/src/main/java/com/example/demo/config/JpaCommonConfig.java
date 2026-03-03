package com.example.demo.config;

import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import java.util.HashMap;

@Configuration
public class JpaCommonConfig {

    @Bean
    public EntityManagerFactoryBuilder entityManagerFactoryBuilder() {

        HibernateJpaVendorAdapter vendorAdapter =
                new HibernateJpaVendorAdapter();

        return new EntityManagerFactoryBuilder(
                vendorAdapter,
                new HashMap<>(),
                null
        );
    }
}
