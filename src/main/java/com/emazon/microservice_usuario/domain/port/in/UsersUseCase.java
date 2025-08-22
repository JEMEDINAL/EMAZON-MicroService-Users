package com.emazon.microservice_usuario.domain.port.in;

import com.emazon.microservice_usuario.adapter.in.dto.AuthCreateUserRequest;
import com.emazon.microservice_usuario.adapter.in.dto.AuthLogIn;
import com.emazon.microservice_usuario.adapter.in.dto.AuthResponse;

public interface UsersUseCase {
    AuthResponse saveUser(AuthCreateUserRequest authCreateUserRequest);
    AuthResponse loginUser(AuthLogIn authLogIn);
}
