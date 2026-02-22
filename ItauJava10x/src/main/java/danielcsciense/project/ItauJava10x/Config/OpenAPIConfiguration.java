package danielcsciense.project.ItauJava10x.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfiguration {

    @Bean
    public OpenAPI apiInfo(){
        return new OpenAPI()
                .info(new Info()
                        .title("Desafio ITAU")
                        .description("Desafio tecnico para vaga de estagio e dev junior no ITAU")
                        .version("1.0.0"));
    }

}
