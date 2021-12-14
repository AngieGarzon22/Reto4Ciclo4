package com.usa.ciclo4.reto2ciclo4.service;

import com.usa.ciclo4.reto2ciclo4.model.Order;
import com.usa.ciclo4.reto2ciclo4.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrder() {
        return orderRepository.getAllOrders();
    }

    public Optional<Order> getOrder(Integer id) {
        return orderRepository.getOrder(id);
    }

    public Order save(Order order) {
        if (order.getId() == null) {
            return order;
        } else {
            return orderRepository.save(order);
        }
    }

    public Order update(Order order) {
        if (order.getId() != null) {
            Optional<Order> revision = orderRepository.getOrder(order.getId());
            if (!revision.isEmpty()) {

                if (order.getId() != null) {
                    revision.get().setId(order.getId());
                }
                if (order.getRegisterDay() != null) {
                    revision.get().setRegisterDay(order.getRegisterDay());
                }
                if (order.getStatus() != null) {
                    revision.get().setStatus(order.getStatus());
                }
                if (order.getSalesMan() != null) {
                    revision.get().setSalesMan(order.getSalesMan());
                }
                if (order.getProducts() != null) {
                    revision.get().setProducts(order.getProducts());
                }
                if (order.getQuantities() != null) {
                    revision.get().setQuantities(order.getQuantities());
                }

                orderRepository.update(revision.get());
                return revision.get();
            } else {
                return order;
            }
        } else {
            return order;
        }
    }

    public boolean delete(Integer id){
        return getOrder(id).map(order ->{
            orderRepository.delete(order);
            return true;
        }).orElse(false);
    }

    public List<Order> getOrderByZone(String zone){
        return orderRepository.getOrderByZone(zone);
    }

    public List<Order> getSalesManId(Integer id){ return orderRepository.getSalesManId(id);}

    public List<Order> getIdStatus(Integer id, String status){ return orderRepository.getIdStatus(id, status);}

    public List<Order> getRegisterDayId(String registerDay, Integer id){
        return orderRepository.getRegisterDayId(registerDay, id);
    }
}