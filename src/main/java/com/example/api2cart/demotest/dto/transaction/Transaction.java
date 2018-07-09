package com.example.api2cart.demotest.dto.transaction;

import com.example.api2cart.demotest.dto.user.User;
import com.example.api2cart.demotest.dto.merchant.Merchant;

import java.time.LocalDateTime;

public class Transaction {

    private Long id;
    private Byte active;
    private LocalDateTime createDate;
    private String note;
    private LocalDateTime updateDate;
    private String currency;
    private Double insuredAmount;
    private Double subtotal;
    private Double taxes;
    private String transactionNumber = "111";
    private User user;
    private Merchant merchant;
}