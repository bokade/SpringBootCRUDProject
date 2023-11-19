package com.example.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="Employee")
public class Employee
{
    @Id
    private String id;
    @NotBlank(message = "Please enter proper employee name")
    @Size(min=5, message = "Name should be atleast 5 characters")
    @Size(max=12, message = "Name should not be greater than 12 characters")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Username should contain only letters and numbers")
    private String fname;
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Username should contain only letters and numbers")
    private String lname;
    private String city;
    private String gender;
    @NotNull(message = "Please enter a valid salary")
    @Min(value=1000, message = "Salary must be atleast 1000.00")
    @Max(value=40000, message = "Salary should not be greater than 40000.00")
    private float salary;
    @Email(message = "Please enter a valid email Id", regexp="^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}")
    @NotNull(message = "Please enter a valid email Id")
    private String email;
    @DBRef
    private Department department;
    private String profile;
    private int age;
    private Family[] family;
    private Instant createdDate;

//    private Family[] family;


}
