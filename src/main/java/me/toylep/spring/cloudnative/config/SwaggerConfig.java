package me.toylep.spring.cloudnative.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger 설정 클래스
 * API 문서 자동화로 팀프로젝트 진행 시에 필요한 config 입니다.
 * 개인 프로젝트시 설정하지 않아도 되며 학습이 목적이므로 한 번 알아봅니다.
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("openAPI")
                        .version("1.0")
                        .description("테스트 문서입니다.")
                        .contact(new Contact().name("담당자").email("test@test.com"))
                );
    }
}
