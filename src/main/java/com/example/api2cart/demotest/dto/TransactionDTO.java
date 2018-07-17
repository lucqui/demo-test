package com.example.api2cart.demotest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

    public TransactionDTO(Byte active, LocalDateTime createDate, String note, LocalDateTime updateDate, String currency, Double insuredAmount, Double subtotal, Double taxes, String transactionNumber, UserDTO user, MerchantDTO merchant) {
        this.active = active;
        this.createDate = createDate;
        this.note = note;
        this.updateDate = updateDate;
        this.currency = currency;
        this.insuredAmount = insuredAmount;
        this.subtotal = subtotal;
        this.taxes = taxes;
        this.transactionNumber = transactionNumber;
        this.user = user;
        this.merchant = merchant;
    }
}