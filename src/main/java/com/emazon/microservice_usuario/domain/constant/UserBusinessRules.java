package com.emazon.microservice_usuario.domain.constant;

public final class UserBusinessRules {
    public UserBusinessRules(){

    }
    public static final int MAX_CHARACTER_NAME = 150;
    public static final int MIN_CHARACTER_NAME = 2;
    public static final int MAX_CHARACTER_LAST_NAME = 200;
    public static final int MIN_CHARACTER_LAST_NAME = 2;
    public static final int MIN_CHARACTER_PASSWORD = 8;
    public static final int MIN_AGE = 18;
    public static final String REQUIRED_CHARACTER_EMAIL_1 = "@";
    public static final String REQUIRED_CHARACTER_EMAIL_2 = ".";
    public static final String REQUIRED_CHARACTER_NUMBER_PHONE = "+";
    public static final int MAX_CHARACTER_PHONE_NUMBER = 14;
    public static final int MAX_CHARACTER_ID_NUMBER = 20;
    public static final int MIN_CHARACTER_ID_NUMBER = 10;
}
