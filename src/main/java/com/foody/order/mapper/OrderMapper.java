package com.foody.order.mapper;

import com.foody.order.dto.OrderDTO;
import com.foody.order.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    public  OrderDTO mapOrderToOrderDTO(Order order);
    public Order mapOrderDTOToOrder(OrderDTO orderDTO);
}


