package com.example.api2cart.demotest.util;

import com.example.api2cart.demotest.dto.MerchantDTO;
import com.example.api2cart.demotest.dto.TransactionDTO;
import com.example.api2cart.demotest.dto.UserDTO;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class JsonParseUtil {

    public List<UserDTO> getUsersFromJson(JsonArray order) {

        List<UserDTO> userDTOS = new ArrayList<>();

        for (int i = 0; i < order.size(); i++) {
            JsonObject objectForGerUser = (JsonObject) order.get(i);
            JsonArray users = (JsonArray) objectForGerUser.get("customer");

            for (int j = 0; j < users.size(); j++) {
                objectForGerUser = users.get(j).getAsJsonObject();

                Long idUser = objectForGerUser.get("id").getAsLong();
                String email = objectForGerUser.get("email").getAsString();
                String first_name = objectForGerUser.get("first_name").getAsString();
                String last_name = objectForGerUser.get("last_name").getAsString();

                userDTOS.add(
                        new UserDTO(
                                idUser,
                                email,
                                first_name,
                                last_name,
                                "middleNameTest",
                                "phoneTest",
                                "typeTest",
                                "userName")
                );
            }
        }
        return userDTOS;
    }

    public List<TransactionDTO> getTransactionFromJson(JsonArray order, Map<String, String> param){

        List<TransactionDTO> transactionDTOS = new ArrayList<>();

        Long orderId = null;
        String createAt = null;
        String modifiedAt = null;
        Double insuredAmount = null;
        Double subtotal = null;
        Double tax = null;
        String currencyName = null;

        for (int i = 0; i < order.size(); i++) {
            JsonObject objectForGerTransaction = (JsonObject) order.get(i);

            orderId = objectForGerTransaction.get("order_id").getAsLong();
            createAt = objectForGerTransaction.get("create_at").getAsString();
            modifiedAt = objectForGerTransaction.get("modified_at").getAsString();


            JsonArray currency = (JsonArray) objectForGerTransaction.get("currency");
            for (int j = 0; j < currency.size(); j++) {
                objectForGerTransaction = currency.get(j).getAsJsonObject();
                currencyName = objectForGerTransaction.get("name").getAsString();
            }


            objectForGerTransaction = (JsonObject) order.get(i);
            JsonArray totals = (JsonArray) objectForGerTransaction.get("totals");
            for (int l = 0; l < totals.size(); l++) {
                objectForGerTransaction = totals.get(l).getAsJsonObject();
                insuredAmount = objectForGerTransaction.get("total").getAsDouble();
                subtotal = objectForGerTransaction.get("subtotal").getAsDouble();
                tax = objectForGerTransaction.get("tax").getAsDouble();
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime createAtLocal = LocalDateTime.parse(createAt, formatter);
            LocalDateTime modifiedAtLocal = LocalDateTime.parse(modifiedAt, formatter);

            List<UserDTO> userDTOList = getUsersFromJson(order);

            transactionDTOS.add(new TransactionDTO(
                    orderId,
                    (byte) 0,
                    createAtLocal,
                    "noteTest",
                    modifiedAtLocal,
                    currencyName,
                    insuredAmount,
                    subtotal,
                    tax,
                    "12",
                    userDTOList.get(i),
                    new MerchantDTO()
            ));
        }

        return transactionDTOS;
    }
}


