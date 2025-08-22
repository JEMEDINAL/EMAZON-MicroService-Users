package com.emazon.microservice_usuario.domain.exception;

import com.emazon.microservice_usuario.domain.constant.UserErrorMessage;

public class ErrorPasswordCredential extends RuntimeException{
    public ErrorPasswordCredential(){
        super(UserErrorMessage.PASSWORD_ERROR_CREDENTIAL);
    }
}
