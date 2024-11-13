package com.example.api.controller.security.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Objects;

@Data
@Schema(description = "Запрос на авторизацию")
public class SignInRequest {
    @Schema(description = "Имя пользователя", example = "Jon")
    @NotBlank(message = "Имя пользователя не может быть пустыми")
    private String username;

    @Schema(description = "Пароль", example = "my_password")
    @NotBlank(message = "Имя пользователя не может быть пустыми")
    private String password;
}
