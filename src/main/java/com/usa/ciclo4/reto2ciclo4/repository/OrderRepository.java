package com.usa.ciclo4.reto2ciclo4.repository;

import com.usa.ciclo4.reto2ciclo4.model.Order;
import com.usa.ciclo4.reto2ciclo4.repository.crud.OrderCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {
    @Autowired
    private OrderCrudRepository orderCrudRepository;

    public List<Order> getAllOrders(){
        return orderCrudRepository.findAll();
    }

    public Optional<Order> getOrder(Integer id){
        return orderCrudRepository.findById(id);
    }

    public Order save(Order order){
        return orderCrudRepository.save(order);
    }

    public void update(Order order){
        orderCrudRepository.save(order);
    }

    public void delete(Order order){
        orderCrudRepository.delete(order);
    }

    public List<Order> getOrderByZone(String zone){
        return orderCrudRepository.findBySalesManZone(zone);
    }

    public List<Order> getSalesManId(Integer id) { return orderCrudRepository.findBySalesManId(id); }

    public List<Order> getIdStatus(Integer id, String status){
        return orderCrudRepository.findBySalesManIdAndStatus(id, status);
    }

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Order> getRegisterDayId(String registerDay, Integer id){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Query query = new Query();

        Criteria dateCriteria = Criteria.where("registerDay")
                .gte(LocalDate.parse(registerDay, dtf).minusDays(1).atStartOfDay())
                .lt(LocalDate.parse(registerDay, dtf).plusDays(1).atStartOfDay())
                .and("salesMan.id").is(id);

        query.addCriteria(dateCriteria);

        return mongoTemplate.find(query,Order.class);
    }

}


