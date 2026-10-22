package br.edu.ifs.web1.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Web 1 - IFS")
                        .description("Documentação da API REST desenvolvida para a disciplina de Programação Web 1 do IFS.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Suporte da Disciplina Web 1")
                                .email("contato@ifs.edu.br"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html")));
    }
}
