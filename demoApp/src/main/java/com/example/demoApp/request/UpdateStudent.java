package com.example.demoApp.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UpdateStudent {
    @NotNull(message = "Student id is required")
    private UUID id;
    private String firstName;
    private String lastName;

    private String email;
}
