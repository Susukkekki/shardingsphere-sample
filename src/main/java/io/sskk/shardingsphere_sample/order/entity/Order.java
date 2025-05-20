package io.sskk.shardingsphere_sample.order.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//@Entity
@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    private String productName;

    private Integer quantity;

    @Column(name = "order_date")
    private LocalDateTime createdAt;

    // Getters and Setters
}