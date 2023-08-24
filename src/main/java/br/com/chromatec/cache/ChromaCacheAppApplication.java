package br.com.chromatec.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ChromaCacheAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChromaCacheAppApplication.class, args);
	}

}
