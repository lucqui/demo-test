package com.example.api2cart.demotest;

import com.example.api2cart.demotest.dto.TransactionDTO;
import com.example.api2cart.demotest.dto.UserDTO;
import com.example.api2cart.demotest.service.MerchantService;
import com.example.api2cart.demotest.service.TransactionService;
import com.example.api2cart.demotest.service.UserService;
import com.example.api2cart.demotest.util.JsonParseUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SpringBootApplication
@EnableJpaRepositories("com.example.api2cart.demotest.dao")
@EntityScan("com.example.api2cart.demotest.model")
public class DemoTestApplication implements CommandLineRunner {

    private UserService userService;
    private MerchantService merchantService;
    private TransactionService transactionService;
    private JsonParseUtil jsonParseUtil;

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

    @Autowired
    public void setJsonParseUtil(JsonParseUtil jsonParseUtil) {
        this.jsonParseUtil = jsonParseUtil;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoTestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> params = new HashMap<>();
        params.put("api_key", "79b8f23e2f9e13075a4dabb818b52632");
        params.put("store_key", "2e41a1d35caaab4dc289e96fac57bbe2");
        params.put("start", "0");
        params.put("count", "30");
        params.put("params", "force_all");

        ResponseEntity<String> response = restTemplate.getForEntity(
                "https://api.api2cart.com/v1.0/order.list.json?api_key={api_key}&store_key={store_key}&start={start}&count={count}&params={params}",
                String.class,
                params
        );

        String jsonResponse = response.getBody();

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject) jsonParser.parse(jsonResponse);
        JsonObject result = (JsonObject) jsonObject.get("result");
        JsonArray order = (JsonArray) result.get("order");

        List<TransactionDTO> transactionDTOS = jsonParseUtil.getTransactionFromJson(order, params);

        for(TransactionDTO transactionDTO : transactionDTOS){
            transactionService.add(transactionDTO);
        }

        System.out.println("finish");
    }
}
