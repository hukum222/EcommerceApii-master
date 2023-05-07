package com.ecommerce.EcommerceApi.service;

import com.ecommerce.EcommerceApi.dao.IOrderRepository;
import com.ecommerce.EcommerceApi.dao.ResourceNotFoundException;
import com.ecommerce.EcommerceApi.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final IOrderRepository orderRepository;

    @Autowired
    public OrderService(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order getOrderById(Integer id) {
        try {
            return orderRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Order", "id"));
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }



    public void deleteOrder(Integer id) {
        Order order = getOrderById(id);
        orderRepository.delete(order);
    }
}

