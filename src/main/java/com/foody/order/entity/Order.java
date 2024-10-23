package com.foody.order.entity;

import com.foody.order.dto.FoodItemDTO;
import com.foody.order.dto.RestaurantDTO;
import com.foody.order.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("order")
public class Order {
    @Id
    private  Integer orderId;
    private List<FoodItemDTO> foodItemDTOList;
    private UserDTO userDTO;
    private RestaurantDTO restaurantDTO;

}
