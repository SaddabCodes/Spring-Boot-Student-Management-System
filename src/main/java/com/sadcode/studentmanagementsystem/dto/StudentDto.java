package com.sadcode.studentmanagementsystem.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class StudentDto {
    private Long id;
    @NotEmpty(message = "student first name should not be empty")
    private String firstName;
    @NotEmpty(message = "student last name should not be empty")
    private String lastName;
    @NotEmpty(message = "student email name should not be empty")
    @Email
    private String email;

    public StudentDto(){

    }
    public StudentDto(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
