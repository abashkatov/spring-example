package com.example.api.controller.security;

import com.example.api.controller.security.dto.JwtResponse;
import com.example.api.controller.security.dto.RefreshTokenRequest;
import com.example.api.controller.security.dto.SignInRequest;
import com.example.api.controller.security.dto.SignUpRequest;
import com.example.api.useCases.auth.refreshToken.RefreshTokenHandler;
import com.example.api.useCases.auth.signIn.SignInHandler;
import com.example.api.useCases.auth.signUp.Command;
import com.example.api.useCases.auth.signUp.SignUpHandler;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Аутентификация")
public class AuthController {
    private final SignUpHandler signUpHandler;
    private final SignInHandler signInHandler;
    private final RefreshTokenHandler refreshTokenHandler;

    @Operation(summary = "Регистрация пользователя")
    @PostMapping("/sign-up")
    public JwtResponse signUp(@RequestBody @Valid SignUpRequest signUpRequest) {
        var command = com.example.api.useCases.auth.signUp.Command.builder()
                .username(signUpRequest.getUsername())
                .password(signUpRequest.getPassword())
                .email(signUpRequest.getEmail())
                .build();

        var jwtPair = signUpHandler.handle(command);

        return JwtResponse.builder()
                .accessToken(jwtPair.getAccessToken())
                .refreshToken(jwtPair.getRefreshToken())
                .build();
    }

    @Operation(summary = "Авторизация пользователя")
    @PostMapping("/sign-in")
    public JwtResponse signIn(@RequestBody @Valid SignInRequest signInRequest) {
        var command = com.example.api.useCases.auth.signIn.Command.builder()
                .username(signInRequest.getUsername())
                .password(signInRequest.getPassword())
                .build();

        var jwtPair = signInHandler.handle(command);

        return JwtResponse.builder()
                .accessToken(jwtPair.getAccessToken())
                .refreshToken(jwtPair.getRefreshToken())
                .build();
    }

    @Operation(summary = "Обновление токена пользователя")
    @PostMapping("/refresh-token")
    public JwtResponse refreshToken(@RequestBody @Valid RefreshTokenRequest refreshTokenRequest) {
        var command = com.example.api.useCases.auth.refreshToken.Command.builder()
                .refreshToken(refreshTokenRequest.getRefreshToken())
                .build();

        var jwtPair = refreshTokenHandler.handle(command);

        return JwtResponse.builder()
                .accessToken(jwtPair.getAccessToken())
                .refreshToken(jwtPair.getRefreshToken())
                .build();
    }
}
