package com.emazon.microservice_usuario.config;

import com.emazon.microservice_usuario.domain.port.in.UsersUseCase;
import com.emazon.microservice_usuario.domain.port.out.UsersRepository;
import com.emazon.microservice_usuario.domain.service.UsersUseCaseService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    public UsersUseCase usersUseCase(UsersRepository usersRepository){
        return new UsersUseCaseService(usersRepository);
    }
}
