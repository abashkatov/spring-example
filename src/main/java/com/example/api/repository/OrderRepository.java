package com.example.api.repository;

import com.example.api.model.Order;
import com.example.api.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {
    Set<Order> findOrdersByUser(User user);

    @Query(value = "SELECT * FROM orders WHERE user_id=?1 AND cost >= ?2 AND cost <= ?3", nativeQuery = true)
    Set<Order> findByCost(long userId, long costGte, long costLte);

    Page<Order> findOrdersByUser(User user, PageRequest pageRequest);
}
