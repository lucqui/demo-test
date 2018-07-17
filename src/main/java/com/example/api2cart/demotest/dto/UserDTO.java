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

    public UserDTO(String email, String firsName, String lastName, String middleName, String phone, String type, String userName) {
        this.email = email;
        this.firsName = firsName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.phone = phone;
        this.type = type;
        this.userName = userName;
    }
}
