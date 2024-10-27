package com.ProjectoJavaSpring.jpa.JAVASPRING.APiexterna;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;



@Configuration
// @EnableJpaRepositories(basePackages = "com.ProjectoJavaSpring.jpa.JAVASPRING.APiexterna")
//  @EntityScan(basePackages = "com.ProjectoJavaSpring.jpa.JAVASPRING.APiexterna")
public class ApiConfig {
@Bean
public RestTemplate restTemplate() {
    return new RestTemplate();
}
}
