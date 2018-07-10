package com.example.api2cart.demotest.controller;

import com.example.api2cart.demotest.dto.TransactionDTO;
import com.example.api2cart.demotest.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    private TransactionService transactionService;

    @Autowired
    public void setTransactionService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }


    @PostMapping("/transaction")
    public ResponseEntity<Void> saveTransaction(@RequestBody TransactionDTO transactionDTO){

        transactionService.add(transactionDTO);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
