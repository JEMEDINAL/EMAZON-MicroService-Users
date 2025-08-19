package com.emazon.microservice_usuario.domain.model;

import java.time.LocalDate;

public class Users {
    private String name;
    private String password;
    private String lastName;
    private int idNumber;
    private String phoneNumber;
    private LocalDate dateBirth;
    private String email;
    private int age;

    public Users(String name, String password, String lastName, int idNumber, String phoneNumber, LocalDate dateBirth, String email,int age) {
        if(name.isEmpty() || lastName.isEmpty() || password.isEmpty()){
            throw new RuntimeException();
        }
        if(!email.contains("@") || email.contains(".")){
            throw new RuntimeException();
        }
        if(!phoneNumber.contains("+") || phoneNumber.length() > 14){
            throw new RuntimeException();
        }
        if(age < 17){
            throw new RuntimeException("racabidkf" + age);
        }
        this.name = name;
        this.password = password;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.phoneNumber = phoneNumber;
        this.dateBirth = dateBirth;
        this.email = email;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
