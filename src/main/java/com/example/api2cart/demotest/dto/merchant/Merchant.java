package com.example.api2cart.demotest.dto.merchant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Merchant {

    private Long id;
    private String apiKey;
    private String businessEmail;
    private String secret;
    private String styling;
    private String url;
}
