package com.emazon.microservice_usuario.domain.port.out;

import com.emazon.microservice_usuario.adapter.in.dto.AuthCreateUserRequest;
import com.emazon.microservice_usuario.adapter.in.dto.AuthResponse;
import com.emazon.microservice_usuario.domain.model.Users;

public interface UsersRepository {

    AuthResponse saveUser(AuthCreateUserRequest authCreateUserRequest);
}
