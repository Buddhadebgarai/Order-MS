package com.foody.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private int userId;
    private  String userPassword;
    private String userName;
    private  String address;
    private  String city;
}
