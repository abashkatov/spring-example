package com.example.api.controller.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class OrderDto {
    private final long orderId;
    private final long userId;
    private final long cost;
}
