package com.example.api2cart.demotest;

import com.example.api2cart.demotest.service.MerchantService;
import com.example.api2cart.demotest.service.TransactionService;
import com.example.api2cart.demotest.service.UserService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableJpaRepositories("com.example.api2cart.demotest.dao")
@EntityScan("com.example.api2cart.demotest.model")
public class DemoTestApplication implements CommandLineRunner {

    private UserService userService;
    private MerchantService merchantService;
    private TransactionService transactionService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setMerchantService(MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @Autowired
    public void setTransactionService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoTestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.getForEntity(
                "https://api.api2cart.com/v1.0/order.list.json?api_key=79b8f23e2f9e13075a4dabb818b52632&store_key=2e41a1d35caaab4dc289e96fac57bbe2&start=0&count=4&params=force_all", String.class);

        String gsonResponse = response.getBody();

        System.out.println(gsonResponse);


    }
}