package com.example.api.repository;

import com.example.api.dto.OrderGroups;
//import com.example.api.dto.ResultOrderGroups;
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
    Set<Order> findOrdersByCostGreaterThanEqual(int cost);

    @Query(value = "SELECT * FROM orders WHERE user_id=?1 AND cost >= ?2 AND cost <= ?3", nativeQuery = true)
    Set<Order> findByCost(long userId, long costGte, long costLte);

    Page<Order> findOrdersByUser(User user, PageRequest pageRequest);

//    @Query("select new ResultOrderGroups(u.id, o.cost) from Order o, User u")
//    Set<OrderGroups> getOrderGroups();

//    @Query(value = "WITH groups as (" +
//            "    select (CASE WHEN o.cost<100 THEN '0-99' ELSE '100-200' END) as groupName, o.cost from orders o" +
//            ")" +
//            "SELECT new OrderGroups(groupName, count(*)) from groups group by groupName;"
//    )
//    Set<OrderGroups> getOrderGroups();
}

// 0-99
// 100-200