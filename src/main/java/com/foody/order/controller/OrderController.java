package com.foody.order.controller;

import com.foody.order.dto.OrderDTO;
import com.foody.order.dto.OrderDTOFromFE;
import com.foody.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/saveOrder")
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTOFromFE orderDTOFromFE)
    {
        OrderDTO savedOrderDetails = orderService.savedNewOrder(orderDTOFromFE);
        return  new ResponseEntity<>(savedOrderDetails, HttpStatus.CREATED);
    }

}


