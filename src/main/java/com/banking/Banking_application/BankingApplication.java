package com.banking.Banking_application;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Bank Application",
				version = "1.0",
				description = "Backend Rest APIs for the Bank Application",
				contact = @Contact(
						name = " Sethu Madhav",
						email = "sethumadhav2467@gmail.com",
						url = "https://github.com/Sethumadhav24"
				),
				license = @License(
						name = "Bank Application",
						url = "https://github.com/Sethumadhav24"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Back Application Documentation",
				url = "https://github.com/Sethumadhav24"
		)

)
public class BankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingApplication.class, args);
	}
}
