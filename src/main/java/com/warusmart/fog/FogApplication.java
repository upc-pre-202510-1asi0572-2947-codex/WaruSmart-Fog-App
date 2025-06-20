package com.warusmart.fog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FogApplication {

	public static void main(String[] args) {
		SpringApplication.run(FogApplication.class, args);
	}

}
