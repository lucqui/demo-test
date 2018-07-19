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

//        Map<String, String> paramsSaveOrdersDB = new HashMap<>();
//        paramsSaveOrdersDB.put("start", "0");
//        paramsSaveOrdersDB.put("count", "30");
//        paramsSaveOrdersDB.put("params", "force_all");
//
//        restTemplateController.saveOrdersDB(paramsSaveOrdersDB);


        Map<String, String> paramsSaveProducts = new HashMap<>();
        paramsSaveProducts.put("name", "Route Shipping Insurance");
        paramsSaveProducts.put("model", "Route Shipping Insurance");
        paramsSaveProducts.put("description", "Route provides protection for shipments that are lost, broken, or stolen. " +
                                              "Add Route to your cart at checkout to enable protection. Visit routeapp.io to learn more.");
        paramsSaveProducts.put("price", "0");

        Map<String, String> variants1 = new HashMap<>();
        variants1.put("model", "route0.98");
        variants1.put("price", "0.98");
        variants1.put("name", "$0.98");
        variants1.put("attributes", "0.98");

        Map<String, String> variants2 = new HashMap<>();
        variants2.put("model", "route5.00");
        variants2.put("price", "5.00");
        variants2.put("name", "$5.00");
        variants2.put("attributes", "5.00");

        Map<String, String> variants3 = new HashMap<>();
        variants3.put("model", "route10.00");
        variants3.put("price", "10.00");
        variants3.put("name", "$10.00");
        variants3.put("attributes", "10.00");

        String productId = restTemplateController.saveProductToCms(paramsSaveProducts);

        restTemplateController.saveProductVariant(productId, variants1);
        restTemplateController.saveProductVariant(productId, variants2);
        restTemplateController.saveProductVariant(productId, variants3);
    }
}
