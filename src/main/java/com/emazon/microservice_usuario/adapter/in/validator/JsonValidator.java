package com.emazon.microservice_usuario.adapter.in.validator;

import com.emazon.microservice_usuario.adapter.in.dto.AuthCreateUserRequest;
import com.emazon.microservice_usuario.adapter.in.dto.AuthLogIn;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@AllArgsConstructor
@Component
public class JsonValidator {
    private final ObjectMapper objectMapper;


    public void validatorJson(AuthCreateUserRequest json) throws JsonProcessingException {
        String jsonString = objectMapper.writeValueAsString(json);
        try{
            objectMapper.readValue(jsonString, AuthCreateUserRequest.class);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void jsonValidatorLogIn(AuthLogIn jsonLogIn) throws JsonProcessingException {
        String jsonString = objectMapper.writeValueAsString(jsonLogIn);
        try{
            objectMapper.readValue(jsonString,AuthLogIn.class);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
