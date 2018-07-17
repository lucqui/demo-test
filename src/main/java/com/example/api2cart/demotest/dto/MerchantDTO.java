package com.example.api2cart.demotest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MerchantDTO {

    private Long id;
    private String apiKey;
    private String businessEmail;
    private String secret;
    private String styling;
    private String url;

    public MerchantDTO(String apiKey, String businessEmail, String secret, String styling, String url) {
        this.apiKey = apiKey;
        this.businessEmail = businessEmail;
        this.secret = secret;
        this.styling = styling;
        this.url = url;
    }
}
