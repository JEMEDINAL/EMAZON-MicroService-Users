package com.emazon.microservice_usuario.adapter.in.dto;


import jakarta.validation.Valid;


import java.time.LocalDate;

public record AuthCreateUserRequest(
        String name,
        String password,
        String lastName,
        int idNumber,
        String phoneNumber,
        LocalDate dateBirth,
        String email,
        int age,
        @Valid AuthCreateRoleRequest roleRequest
) {

}
