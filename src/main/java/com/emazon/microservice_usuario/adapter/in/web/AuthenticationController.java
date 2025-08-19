package com.emazon.microservice_usuario.adapter.in.web;

import com.emazon.microservice_usuario.adapter.in.dto.AuthCreateUserRequest;
import com.emazon.microservice_usuario.adapter.in.dto.AuthResponse;
import com.emazon.microservice_usuario.domain.port.in.UsersUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final UsersUseCase usersUseCase;

    public AuthenticationController(UsersUseCase usersUseCase) {
        this.usersUseCase = usersUseCase;
    }

    @PostMapping("/sing-up")
    public ResponseEntity<AuthResponse> register(@RequestBody @Valid AuthCreateUserRequest authCreateUserRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(usersUseCase.saveUser(authCreateUserRequest));
    }
}
