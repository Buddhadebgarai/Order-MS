package com.foody.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private  Integer orderId;
    private List<FoodItemDTO> foodItemDTOList;
    private UserDTO userDTO;
    private RestaurantDTO restaurantDTO;
}
