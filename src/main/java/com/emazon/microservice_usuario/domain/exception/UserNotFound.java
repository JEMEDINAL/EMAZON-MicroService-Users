package com.emazon.microservice_usuario.domain.exception;

import com.emazon.microservice_usuario.domain.constant.UserErrorMessage;

public class UserNotFound extends RuntimeException{
    public UserNotFound(){
        super(UserErrorMessage.NOT_FOUND_USER);
    }
}
