package com.example.dto;

import com.example.model.Department;
import com.example.model.Family;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.Instant;

@Data
public class EmployeeDto
{

//    private long id;
//    private String fname;
//    private String lname;
//    private String city;
//    private String gender;
//    private float salary;
//    private String email;
//    private Department department;
//    private String profile;
//    private int age;
//    private Family[] family;
//    private Instant createdDate;

    private String id;
    private String fname;
    private String lname;
    private String city;
    private String gender;
    private float salary;
    private String email;
    private Department department;
    private String profile;
    private int age;
    private Family[] family;
    private Instant createdDate;


}
