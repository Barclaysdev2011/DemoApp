package com.example.demoApp.response;


import com.example.demoApp.entity.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class StudentResponse {
    private UUID id;
    private String firstName;

    private String lastName;

    private String email;

    public StudentResponse(Student student){
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.email = student.getEmail();

    }
}
