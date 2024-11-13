package com.example.api.useCases.auth.signIn;

import com.example.api.repository.UserRepository;
import com.example.api.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignInHandler {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public Response handle(Command command) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        command.getUsername(),
                        command.getPassword()
                )
        );

        var user = userRepository.findByUsername(command.getUsername());
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Username not found");
        }

        var accessToken = jwtService.generateToken(user.get());

        return new Response(accessToken, "");
    }
}
