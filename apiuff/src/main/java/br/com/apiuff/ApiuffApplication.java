package br.com.apiuff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport // Pagination
@EnableCaching // Cache
public class ApiuffApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiuffApplication.class, args);
    }

}
