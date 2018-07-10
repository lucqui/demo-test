package com.example.api2cart.demotest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;
    private String email;
    private String firsName;
    private String lastName;
    private String middleName;
    private String phone;
    private String type;
    private String userName;
}
