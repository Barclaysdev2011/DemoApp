package com.example.demoApp.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;


@Getter
@Setter
public class CreateStudentRequest {
    @NotBlank(message = "First name is required")
    private String firstName;
    private String lastName;

    private String email;
}
