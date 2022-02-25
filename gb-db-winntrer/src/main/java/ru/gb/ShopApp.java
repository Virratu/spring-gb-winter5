package ru.gb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.gb.config.JpaConfig;

@EnableConfigurationProperties
@SpringBootApplication
public class ShopApp {

    public static void main(String[] args) {
        SpringApplication.run(ShopApp.class, args);

    }
}
