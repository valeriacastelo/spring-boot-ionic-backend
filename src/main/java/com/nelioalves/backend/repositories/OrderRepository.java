package com.nelioalves.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nelioalves.backend.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
