package com.example.api2cart.demotest.controller;

import com.example.api2cart.demotest.dto.MerchantDTO;
import com.example.api2cart.demotest.dto.TransactionDTO;
import com.example.api2cart.demotest.dto.UserDTO;
import com.example.api2cart.demotest.service.MerchantService;
import com.example.api2cart.demotest.service.TransactionService;
import com.example.api2cart.demotest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestController
public class TransactionController {

    private TransactionService transactionService;
    private UserService userService;
    private MerchantService merchantService;

    @Autowired
    public void setTransactionService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setMerchantService(MerchantService merchantService) {
        this.merchantService = merchantService;
    }


    //https://api.api2cart.com/v1.0/order.add.json?api_key=79b8f23e2f9e13075a4dabb818b52632&store_key=2e41a1d35caaab4dc289e96fac57bbe2&order_status=Open&customer_email=admin@mail.com&bill_first_name=John&bill_last_name=Smith&bill_address_1=Green%20str.35&bill_city=Chicago&bill_postcode=12345&bill_state=IL&bill_country=US&total_price=1.15&date=2012-09-25%2019:40:00&order_item_id_1=1315673964611&order_item_name_1=Product%201&order_item_model_1=sku_1&order_item_price_1=1.15&order_item_quantity_1=1&order_item_option_name_1_1=Title&order_item_option_value_1_1=$1.15&order_item_option_price_1_1=0&currency=23&tax_price=43


    @PostMapping("api.api2cart.com/v1.0/order.add.json")
    public ResponseEntity<Void> saveTransaction(@RequestParam("api_key")String api_key,
                                                HttpServletRequest request,
                                                @RequestParam("customer_email") String customerEmail,
                                                @RequestParam("bill_first_name") String billFirstName,
                                                @RequestParam("bill_last_name") String billLastName,
                                                @RequestParam("date") LocalDateTime dateTime,
                                                @RequestParam("currency") String currency,
                                                @RequestParam("date") LocalDateTime updateDate,
                                                @RequestParam("order_item_price_1") Double orderItemPrice1,
                                                @RequestParam("total_price") Double totalPrice,
                                                @RequestParam("tax_price") Double taxPrice){

        merchantService.add(new MerchantDTO(api_key, customerEmail, "testMerchant", "testMerchant", request.getRequestURL().toString()));

        userService.add(
                new UserDTO(customerEmail, billFirstName, billLastName, "testUser", "testUser", "testUser", "testUser")
        );

        transactionService.add(
                new TransactionDTO(
                        (byte) 1,
                        dateTime,
                        "testNote",
                        updateDate,
                        currency,
                        orderItemPrice1,
                        totalPrice,
                        taxPrice,
                        "45",
                        userService.get(1L),
                        merchantService.get(1L))
        );

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
