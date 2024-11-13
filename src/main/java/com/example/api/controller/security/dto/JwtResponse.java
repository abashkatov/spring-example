package com.example.api.controller.security.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description = "Ответ c токеном доступа")
public class JwtResponse {
    @Schema(description = "Токен доступа", example = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6IjEzMzciLCJ1c2VybmFtZSI6ImJpem9uZSIsImlhdCI6MTU5NDIwOTYwMCwicm9sZSI6InVzZXIifQ.ZvkYYnyM929FM4NW9_hSis7_x3_9rymsDAx9yuOcc1I")
    private String accessToken;

    @Schema(description = "Refresh доступа", example = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9")
    private String refreshToken;
}
