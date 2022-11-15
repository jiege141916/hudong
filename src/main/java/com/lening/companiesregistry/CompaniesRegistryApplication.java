package com.lening.companiesregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.lening.mapper"})
public class CompaniesRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompaniesRegistryApplication.class, args);
    }

}
