package java_spring_challenge.config;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Aplicação RESTful")
                        .version("1.0")
                        .description("API para gerenciamento de agendamentos de um salão de barbeiro")
                        .termsOfService("Termo de uso: Open Source")
                        .license(new License()
                                .name("Licença - Sua Empresa")
                                .url("http://www.springchallenge.com.br"))
                        .contact(new Contact()
                                .name("Suporte")
                                .email("suporte@springchallenge.com.br")
                                .url("http://www.springchallenge.com.br")));
    }
}