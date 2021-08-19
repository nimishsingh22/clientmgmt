package com.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientApplication extends SpringBootServletInitializer {
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ClientApplication.class);
    }
	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}
	@Bean
	public org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
	}

}
