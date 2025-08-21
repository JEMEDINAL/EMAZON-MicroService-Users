package com.emazon.microservice_usuario.domain.service;

import com.emazon.microservice_usuario.adapter.in.dto.AuthCreateUserRequest;
import com.emazon.microservice_usuario.adapter.in.dto.AuthResponse;
import com.emazon.microservice_usuario.domain.constant.UserBusinessRules;
import com.emazon.microservice_usuario.domain.exception.InvalidEmail;

import com.emazon.microservice_usuario.domain.exception.InvalidPhoneNumber;
import com.emazon.microservice_usuario.domain.port.in.UsersUseCase;
import com.emazon.microservice_usuario.domain.port.out.UsersRepository;

public class UsersUseCaseService implements UsersUseCase {
    private final UsersRepository usersRepository;

    public UsersUseCaseService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public AuthResponse saveUser(AuthCreateUserRequest authCreateUserRequest) {
        if(!authCreateUserRequest.email().contains(UserBusinessRules.REQUIRED_CHARACTER_EMAIL_1) || !authCreateUserRequest.email().contains(UserBusinessRules.REQUIRED_CHARACTER_EMAIL_2)){
            throw new InvalidEmail();
        }
        if(!authCreateUserRequest.phoneNumber().contains(UserBusinessRules.REQUIRED_CHARACTER_NUMBER_PHONE)){
            throw new InvalidPhoneNumber();
        }
        return usersRepository.saveUser(authCreateUserRequest) ;
    }
}
