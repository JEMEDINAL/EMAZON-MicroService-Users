package com.emazon.microservice_usuario.domain.port.out;

import com.emazon.microservice_usuario.adapter.in.dto.AuthCreateUserRequest;
import com.emazon.microservice_usuario.adapter.in.dto.AuthLogIn;
import com.emazon.microservice_usuario.adapter.in.dto.AuthResponse;


public interface UsersRepository {
    AuthResponse saveUser(AuthCreateUserRequest authCreateUserRequest);
    AuthResponse loginUser(AuthLogIn authLogIn);
}
