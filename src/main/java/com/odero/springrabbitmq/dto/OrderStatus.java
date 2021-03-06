package com.odero.springrabbitmq.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class OrderStatus {
    private Order order;
    private String status; // i.e progress, complete
    private String message;
}
