package com.example.api2cart.demotest.controller;

import com.example.api2cart.demotest.dto.MerchantDTO;
import com.example.api2cart.demotest.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MerchantController {

    private MerchantService merchantService;

    @Autowired
    public void setMerchantService(MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @PostMapping("/merchant")
    public ResponseEntity<Void> saveMerchant(@RequestBody MerchantDTO merchantDTO){

        merchantService.add(merchantDTO);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
