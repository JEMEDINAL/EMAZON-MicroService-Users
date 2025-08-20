package com.emazon.microservice_usuario.domain.constant;

public final class UserErrorMessage {
    public UserErrorMessage() {

    }
    public static final String USER_NAME_CHARACTER = "The name must be between 2 and 150 characters long.";
    public static final String USER_NOT_BLANK_NAME = "The name cannot be left blank.";
    public static final String USER_LAST_NAME_CHARACTER = "The last name must be between 2 and 200 characters long.";
    public static final String USER_NOT_BLANK_LAST_NAME = "The last name field cannot be left blank.";
    public static final String USER_PASSWORD_CHARACTER = "The password must be at least 8 characters long and cannot be empty.";
    public static final String USER_ID_NUMBER = "The ID number must be between 10 and 20.";
    public static final String USER_ID_NUMBER_NOT_BLANK = "The ID number cannot be empty.";
    public static final String USER_PHONE_NUMBER_NOT_BLANK ="The Phone Number cannot be empty";
    public static final String USER_PHONE_NUMBER = "The phone number cannot be longer than 14 characters.";
    public static final String USER_BIRTH_DATA_NOT_BLANK = "The Birth date cannot be empty";
    public static final String USER_EMAIL_NOT_BLANK ="The email date cannot be empty";
    public static final String USER_INVALID_EMAIL = "The email format is invalid required @ to .";
    public static final String USER_INVALID_PHONE_NUMBER = "The phone number is invalid. It requires +.";
    public static final String USER_AGE_NOT_BLANK = "Age verification is mandatory and cannot be left blank.";
    public static final String USER_LEGAL_AGE = "You must be of legal age to create your account.";
    public static final String USER_ID_NUMBER_POSITIVE= "The ID number must be positive.";
    public static final String USER_AGE_POSITIVE = "The age must be positive.";
}
