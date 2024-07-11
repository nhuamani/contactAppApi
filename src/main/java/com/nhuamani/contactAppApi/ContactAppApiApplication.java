package com.nhuamani.contactAppApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@SpringBootApplication
public class ContactAppApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactAppApiApplication.class, args);
	}

}
