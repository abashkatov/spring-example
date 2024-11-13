package com.example.api.useCases.auth.signUp;

import com.example.api.model.Role;
import com.example.api.model.User;
import com.example.api.repository.UserRepository;
import com.example.api.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpHandler {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public Response handle(Command command) {
        var passwordHash = passwordEncoder.encode(command.getPassword());
        var user = User.builder()
                .username(command.getUsername())
                .email(command.getEmail())
                .password(passwordHash)
                .role(Role.ROLE_USER)
                .build();

        userRepository.save(user);
        var accessToken = jwtService.generateToken(user);

        return new Response(accessToken, "");
    }
}
