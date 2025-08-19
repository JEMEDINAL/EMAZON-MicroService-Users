package com.emazon.microservice_usuario.domain.service;

import com.emazon.microservice_usuario.adapter.in.dto.AuthCreateUserRequest;
import com.emazon.microservice_usuario.adapter.in.dto.AuthResponse;
import com.emazon.microservice_usuario.domain.model.Users;
import com.emazon.microservice_usuario.domain.port.in.UsersUseCase;
import com.emazon.microservice_usuario.domain.port.out.UsersRepository;

public class UsersUseCaseService implements UsersUseCase {
    private final UsersRepository usersRepository;

    public UsersUseCaseService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public AuthResponse saveUser(AuthCreateUserRequest authCreateUserRequest) {
        /*
        new Users(authCreateUserRequest.name(),
                authCreateUserRequest.password(),
                authCreateUserRequest.lastName(),
                authCreateUserRequest.idNumber(),
                authCreateUserRequest.phoneNumber(),
                authCreateUserRequest.dateBirth(),
                authCreateUserRequest.email(),
                authCreateUserRequest.age()
        );
        */
        System.out.println("authCreateUserRequest = " + authCreateUserRequest.roleRequest().roleListName().size());
        return usersRepository.saveUser(authCreateUserRequest) ;
    }
}
