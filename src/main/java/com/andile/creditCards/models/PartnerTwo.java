package com.andile.creditCards.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartnerTwo {
    private String card;
    private double apr;
    private double approvalRating;
    private  String provider;
}
