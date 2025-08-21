package com.emazon.microservice_usuario.domain.exception;

import com.emazon.microservice_usuario.domain.constant.UserErrorMessage;

public class InvalidEmail extends RuntimeException{
    public InvalidEmail(){
        super(UserErrorMessage.USER_INVALID_EMAIL);
    }
}
