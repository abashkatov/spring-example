package com.example.api.useCases.auth.signIn;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Command {
    private String username;
    private String email;
    private String password;
}
