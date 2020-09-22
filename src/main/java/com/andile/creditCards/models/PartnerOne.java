package com.andile.creditCards.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartnerOne {
    private String cardName;
    private double apr;
    private double eligibility;
    private  String provider;
}
