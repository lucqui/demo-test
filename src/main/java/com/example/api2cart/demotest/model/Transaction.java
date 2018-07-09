package com.example.api2cart.demotest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "active")
    private Byte active;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "note")
    private String note;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @Column(name = "currency")
    private String currency;

    @Column(name = "insured_amount")
    private Double insuredAmount;

    @Column(name = "subtotal")
    private Double subtotal;

    @Column(name = "taxes")
    private Double taxes;

    @Column(name = "transaction_number")
    private String transactionNumber = "111";

    @OneToOne(optional=false, fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(optional=false, fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "merchant_id")
    private Merchant merchant;
}
