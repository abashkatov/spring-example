package com.example.api.service;

import com.example.api.model.Order;
import com.example.api.model.User;
import com.example.api.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public Set<Order> getOrdersByUser(User user) {
//        return orderRepository.findOrdersByUser(user);
        return orderRepository
                .findOrdersByUser(user, PageRequest.of(2, 10))
                .toSet();
    }
}
