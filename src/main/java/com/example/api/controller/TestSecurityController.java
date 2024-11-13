package com.example.api.controller;

import com.example.api.controller.dto.HelloWorldResponse;
import com.example.api.controller.dto.OrderDto;
import com.example.api.model.Order;
import com.example.api.repository.OrderRepository;
import com.example.api.repository.UserRepository;
import com.example.api.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/test-security")
@RequiredArgsConstructor
public class TestSecurityController {
    private final UserRepository userRepository;
    private final OrderService orderService;

    @GetMapping
//    public Set<Order> testSecurity(@AuthenticationPrincipal UserDetails userDetails) {
//    public Set<Order> testSecurity(Authentication authentication) {
    public Set<OrderDto> testSecurity(Principal principal) {
        var user = userRepository
                .findByUsername(principal.getName())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        var orders = orderService.getOrdersByUser(user);

        return orders
                .stream()
                .map((order) -> new OrderDto(
                        order.getId(),
                        order.getUser().getId(),
                        order.getCost()
                ))
                .collect(Collectors.toSet());
    }

}
