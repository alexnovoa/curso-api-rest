package com.curso.spring.api.configs;

import java.util.Date;

import com.curso.spring.api.security.UsuarioDetailServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@Profile("dev")
@EnableSwagger2
public class SwaggerConfig {

    @Autowired
    private UsuarioDetailServiceImpl userDetailsService;

    @Bean
    public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2).select()
        .apis(RequestHandlerSelectors.basePackage("com.curso.spring.api.controllers"))
        .paths(PathSelectors.any()).build()
        .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("API")
        .description("API Documentation to access end points").version("1.0")
        .build();
    }


    @Bean
    public SecurityConfiguration security() {
        String token;
        try {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername("alex");

            token = Jwts.builder().setIssuedAt(new Date()).setIssuer("Curso de spring boot")
					.setSubject(userDetails.getUsername())
					.setExpiration(new Date(System.currentTimeMillis() + 850000))
					.signWith(SignatureAlgorithm.HS512, "8iejhdghdj").compact();
         
        } catch (Exception e) {
            token = "";
        }

        System.out.println("Token to access swagger: " + token);

        return new SecurityConfiguration(null, null, null, null, "Bearer " + token, ApiKeyVehicle.HEADER,
                "Authorization", ",");
    }
    
}