package io.sskk.shardingsphere_sample.order.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import io.sskk.shardingsphere_sample.order.repository.OrderRepository;
import io.sskk.shardingsphere_sample.order.entity.Order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public List<Order> getAllOrders(@AuthenticationPrincipal Jwt jwt) {
        String location = jwt.getClaimAsString("location");
        // 📝 로그 출력
        logger.info("Authenticated user's location: {}", location);
        
        return orderRepository.findAll();
    }
}
