package org.spring.oauth2.email_validate_register.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .version("v1.0.0")
                .title("기록용 프로젝트")
                .description("Spring Security + 회원 가입 이메일 인증");
        return new OpenAPI()
                .info(info);
    }   //  ToDO 옵션들을 나중에 더 알아보자
    
}
