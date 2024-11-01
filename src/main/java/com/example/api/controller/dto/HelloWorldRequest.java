package com.example.api.controller.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Objects;

@Data
public class HelloWorldRequest {
    @NotBlank
    private String message;

    private String repeatMessage;

    @AssertTrue(message = "Fields is not match.")
    private boolean isMessageSame() {
        return Objects.equals(message, repeatMessage);
    }
}
