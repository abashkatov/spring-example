package com.example.api.useCases.auth.refreshToken;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Command {
    private String refreshToken;
}
