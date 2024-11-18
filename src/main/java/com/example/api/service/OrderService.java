package com.example.api.service;

import com.example.api.dto.OrderGroups;
//import com.example.api.dto.ResultOrderGroups;
import com.example.api.model.Order;
import com.example.api.model.User;
import com.example.api.repository.OrderRepository;
import com.example.api.repository.OrderRepositoryImp;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderRepositoryImp orderRepositoryImp;

    public List<Order> getOrdersByUser(User user) {
//        return orderRepository.findOrdersByUser(user);
        return orderRepositoryImp.getOrders();
//        return orderRepository.getOrderGroups();
//        return orderRepository
//                .findOrdersByUser(user, PageRequest.of(3, 10))
//                .toSet();
    }
}
