package com.example.api.useCases.auth.signUp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Command {
    private String username;
    private String email;
    private String password;
}
