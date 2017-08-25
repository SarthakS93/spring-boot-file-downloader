package com.stayprime.appdownloader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class StayprimeAppdownloaderApplication extends SpringBootServletInitializer {
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(StayprimeAppdownloaderApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(StayprimeAppdownloaderApplication.class, args);
	}
}
