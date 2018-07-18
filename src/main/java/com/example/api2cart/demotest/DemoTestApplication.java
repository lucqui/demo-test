package com.example.api2cart.demotest;

import com.example.api2cart.demotest.resttemplate.RestTemplateController;
import com.example.api2cart.demotest.service.MerchantService;
import com.example.api2cart.demotest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.HashMap;
import java.util.Map;


@SpringBootApplication
@EnableJpaRepositories("com.example.api2cart.demotest.dao")
@EntityScan("com.example.api2cart.demotest.model")
public class DemoTestApplication implements CommandLineRunner {

    private RestTemplateController restTemplateController;

    @Autowired
    public void setRestTemplateController(RestTemplateController restTemplateController) {
        this.restTemplateController = restTemplateController;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoTestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Map<String, String> params = new HashMap<>();
        params.put("api_key", "79b8f23e2f9e13075a4dabb818b52632");
        params.put("store_key", "2e41a1d35caaab4dc289e96fac57bbe2");
        params.put("start", "0");
        params.put("count", "30");
        params.put("params", "force_all");

        restTemplateController.saveOrdersDB(params);
    }
}
