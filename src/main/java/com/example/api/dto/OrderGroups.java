package com.example.api.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Data;

@Data
public class OrderGroups {
    private int userId;
    private int count;

    public OrderGroups(int userId, int count) {
        this.userId = userId;
        this.count = count;
    }
}
