package senai.weg.entidade.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("API de consultorio")
                        .description("API para gerenciamento de consultorios médicos")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Kotryk")
                                .email("Kotryk@e.com"))
                        .license(new License()
                                .name("Licença - MIT")
                                .url("https://opensource.org/licenses/MIT")));

    }
}
