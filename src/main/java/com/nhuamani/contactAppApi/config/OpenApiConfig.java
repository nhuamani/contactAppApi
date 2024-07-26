package com.nhuamani.contactAppApi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Contact App REST APIs",
        version = "1.0",
        description = "Documentation for endpoints of Contact List App"
    )
)
public class OpenApiConfig {

}
