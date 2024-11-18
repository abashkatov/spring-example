package com.example.api.repository;

import com.example.api.model.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class OrderRepositoryImp {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Order> getOrders() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Order> query = cb.createQuery(Order.class);
        Root<Order> order = query.from(Order.class);

//        Path<String> emailPath = user.get("email");

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.between(order.get("cost"), 1, 100));
        predicates.add(cb.greaterThanOrEqualTo(order.get("id"), 10));
//        for (String email : emails) {
//            predicates.add(cb.like(emailPath, email));
//        }
//        query.select()
        query.select(order)
                .where(
                        cb.or(
                                predicates.toArray(new Predicate[predicates.size()])
                        )
                )
        ;

        return entityManager.createQuery(query)
                .getResultList();
    }
}
