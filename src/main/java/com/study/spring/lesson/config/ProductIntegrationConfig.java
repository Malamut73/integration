package com.study.spring.lesson.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("integration/http-products-gateway.xml")
public class ProductIntegrationConfig {
}