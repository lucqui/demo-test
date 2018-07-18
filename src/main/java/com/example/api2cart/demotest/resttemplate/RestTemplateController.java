package com.example.api2cart.demotest.resttemplate;

import com.example.api2cart.demotest.dto.TransactionDTO;
import com.example.api2cart.demotest.service.TransactionService;
import com.example.api2cart.demotest.util.JsonParseUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
;
import java.util.List;
import java.util.Map;

@Component
public class RestTemplateController {

    private RestTemplate restTemplate = new RestTemplate();
    private TransactionService transactionService;
    private JsonParseUtil jsonParseUtil;

    @Autowired
    public void setJsonParseUtil(JsonParseUtil jsonParseUtil) {
        this.jsonParseUtil = jsonParseUtil;
    }

    @Autowired
    public void setTransactionService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public void saveOrdersDB(Map<String, String> params) {

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

        List<TransactionDTO> transactionDTOS = jsonParseUtil.getTransactionFromJson(order);

        for (TransactionDTO transactionDTO : transactionDTOS) {
            transactionService.add(transactionDTO);
        }

        System.out.println("finish");
    }

    public void saveOrderToCms(){

    }
}
