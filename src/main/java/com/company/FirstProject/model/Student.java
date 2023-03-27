package com.company.FirstProject.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Student {
    private Integer studentId;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Integer age;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
