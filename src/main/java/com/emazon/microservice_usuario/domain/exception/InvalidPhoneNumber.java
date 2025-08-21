package com.emazon.microservice_usuario.domain.exception;

import com.emazon.microservice_usuario.domain.constant.UserErrorMessage;

public class InvalidPhoneNumber extends RuntimeException{
    public InvalidPhoneNumber(){
        super(UserErrorMessage.USER_INVALID_PHONE_NUMBER);
    }
}
