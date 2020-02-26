package com.devin;

import com.devin.repository.base.BaseRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Slf4j
@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "com.devin.repository", repositoryBaseClass = BaseRepositoryImpl.class)
public class TheatreApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(TheatreApplication.class, args);
        String serverPort = context.getEnvironment().getProperty("server.port");
        log.info("theatre started at http://localhost:" + serverPort);
    }

}
