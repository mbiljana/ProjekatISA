package com.example.ISAprojekat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication (exclude = {DataSourceAutoConfiguration.class})
public class IsAprojekatApplication {

	public static void main (String[] args) {
		SpringApplication.run(IsAprojekatApplication.class, args);





	}

}
