package com.foody.order.service;

import com.foody.order.dto.OrderDTO;
import com.foody.order.dto.OrderDTOFromFE;
import com.foody.order.dto.UserDTO;
import com.foody.order.entity.Order;
import com.foody.order.mapper.OrderMapper;
import com.foody.order.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    SequenceGenerator sequenceGenerator;

    @Autowired
    RestTemplate restTemplate;

    public OrderDTO savedNewOrder(OrderDTOFromFE orderDTOFromFE) {
        int newOrderID = sequenceGenerator.generateNewOrderId();
        UserDTO userDTO = fetchUserDetailsById(orderDTOFromFE.getUserId());
        Order newOrder = new Order(newOrderID,orderDTOFromFE.getFoodItemDTOList(), userDTO, orderDTOFromFE.getRestaurantDTO());
        orderRepo.save(newOrder);
        return OrderMapper.INSTANCE.mapOrderToOrderDTO(newOrder);

    }

    private UserDTO fetchUserDetailsById(Integer userId) {

        return  restTemplate.getForObject("http://USER-SERVICE/user/fetchUserById/"+userId, UserDTO.class);
    }
}
