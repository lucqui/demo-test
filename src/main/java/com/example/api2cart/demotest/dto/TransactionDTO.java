package com.example.api2cart.demotest.dto;

import java.time.LocalDateTime;

public class TransactionDTO {

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
    private UserDTO user;
    private MerchantDTO merchant;
}