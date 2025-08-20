package com.emazon.microservice_usuario.adapter.in.dto;


import com.emazon.microservice_usuario.domain.constant.UserBusinessRules;
import com.emazon.microservice_usuario.domain.constant.UserErrorMessage;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;


import java.time.LocalDate;

public record AuthCreateUserRequest(
        @NotBlank(message = UserErrorMessage.USER_NOT_BLANK_NAME)
        @Size(min = UserBusinessRules.MIN_CHARACTER_NAME,max = UserBusinessRules.MAX_CHARACTER_NAME, message = UserErrorMessage.USER_NAME_CHARACTER )
        String name,
        @NotBlank(message = UserErrorMessage.USER_PASSWORD_CHARACTER)
        @Size(min = UserBusinessRules.MIN_CHARACTER_PASSWORD, message = UserErrorMessage.USER_PASSWORD_CHARACTER)
        String password,
        @NotBlank(message = UserErrorMessage.USER_NOT_BLANK_LAST_NAME)
        @Size(min = UserBusinessRules.MIN_CHARACTER_LAST_NAME,max = UserBusinessRules.MAX_CHARACTER_LAST_NAME,message = UserErrorMessage.USER_LAST_NAME_CHARACTER)
        String lastName,
        @NotNull(message = UserErrorMessage.USER_ID_NUMBER_NOT_BLANK)
        @Min(value = UserBusinessRules.MIN_CHARACTER_ID_NUMBER,message = UserErrorMessage.USER_ID_NUMBER)
        @Positive(message = UserErrorMessage.USER_ID_NUMBER_POSITIVE)
        int idNumber,
        @NotBlank(message = UserErrorMessage.USER_PHONE_NUMBER_NOT_BLANK)
        @Size(max = UserBusinessRules.MAX_CHARACTER_PHONE_NUMBER ,message = UserErrorMessage.USER_PHONE_NUMBER)
        String phoneNumber,

        LocalDate dateBirth,
        @NotBlank(message = UserErrorMessage.USER_EMAIL_NOT_BLANK)
        String email,
        @NotNull(message = UserErrorMessage.USER_AGE_NOT_BLANK)
        @Min(value = UserBusinessRules.MIN_AGE, message = UserErrorMessage.USER_AGE_POSITIVE)
        int age,
        @Valid AuthCreateRoleRequest roleRequest
) {

}
