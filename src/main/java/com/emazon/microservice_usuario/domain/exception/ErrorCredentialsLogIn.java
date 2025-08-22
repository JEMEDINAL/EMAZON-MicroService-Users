package com.emazon.microservice_usuario.domain.exception;

import com.emazon.microservice_usuario.domain.constant.UserErrorMessage;

public class ErrorCredentialsLogIn extends RuntimeException{
    public ErrorCredentialsLogIn(){
        super(UserErrorMessage.LOGIN_ERROR_CREDENTIALS);
    }
}
