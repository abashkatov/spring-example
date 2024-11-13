package com.example.api.controller.security.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Objects;

@Data
@Schema(description = "Обновление токена доступа")
public class RefreshTokenRequest {
    @Schema(description = "Refresh token")
    @NotBlank(message = "Refresh token не может быть пустыми")
    private String refreshToken;
}
