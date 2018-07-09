package com.example.api2cart.demotest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Merchant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "api_key")
    private String apiKey;

    @Column(name = "business_email")
    private String businessEmail;

    @Column(name = "secret")
    private String secret;

    @Column(name = "styling")
    private String styling;

    @Column(name = "url")
    private String url;
}
