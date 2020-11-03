package com.examen.apirest;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan
public class ApirestApplication {
	private static final Logger log = LoggerFactory.getLogger(ApirestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ApirestApplication.class, args);
	}

}
