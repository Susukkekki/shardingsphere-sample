package io.sskk.shardingsphere_sample.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import io.sskk.shardingsphere_sample.order.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
