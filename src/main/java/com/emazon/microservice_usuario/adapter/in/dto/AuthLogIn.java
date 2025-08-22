package com.emazon.microservice_usuario.adapter.in.dto;

import com.emazon.microservice_usuario.domain.constant.UserErrorMessage;
import jakarta.validation.constraints.NotBlank;

public record AuthLogIn(
        @NotBlank(message = UserErrorMessage.USER_EMAIL_NOT_BLANK)
        String email,
        @NotBlank(message = UserErrorMessage.LOGIN_PASSWORD_NOT_BLANK)
        String password
) {
}
