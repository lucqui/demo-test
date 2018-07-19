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

    private final static String apiKey = "79b8f23e2f9e13075a4dabb818b52632";
    private final static String storeKey = "2e41a1d35caaab4dc289e96fac57bbe2";

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
                "https://api.api2cart.com/v1.0/order.list.json?api_key=" + apiKey + "&store_key=" + storeKey + "&start={start}&count={count}&params={params}",
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

    public void saveProductToCms(Map<String, String> paramsSaveProduct, Map<String, String> variants){

        ResponseEntity<String> response = restTemplate.getForEntity(
                "https://api.api2cart.com/v1.0/product.add.json?api_key=" + apiKey + "&store_key=" + storeKey + "&" +
                        "name={name}&" +
                        "model={model}&" +
                        "description={description}&" +
                        "price={price}",
                String.class,
                paramsSaveProduct
        );

        String responseProduct = response.getBody();

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject) jsonParser.parse(responseProduct);
        JsonObject result = (JsonObject) jsonObject.get("result");
        String productId = result.get("product_id").getAsString();

        if (!productId.isEmpty() && !variants.isEmpty()) {

            ResponseEntity<String> responseVariants = restTemplate.getForEntity(
                    "https://api.api2cart.com/v1.0/product.variant.add.json?api_key=" + apiKey + "&store_key=" + storeKey + "&" +
                            "product_id=1320984182851&" +
                            "model=v_5a4b9b12e9359&" +
                            "name=test&" +
                            "weight=12.00&" +
                            "quantity=9&" +
                            "attributes[Size][XL]=3\n",
                    String.class,
                    variants
            );

        }

    }
}
