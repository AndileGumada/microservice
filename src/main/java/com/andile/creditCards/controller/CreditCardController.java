package com.andile.creditCards.controller;

import com.andile.creditCards.dto.UserDTO;
import com.andile.creditCards.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditCardController {
    @Autowired
    CreditCardService creditCardService;

    @PostMapping("/v1/cards")
    public ResponseEntity<?> getCards(@RequestBody UserDTO userDTO){
        return creditCardService.getCreditCards(userDTO);
    }
}