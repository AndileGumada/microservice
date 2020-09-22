package com.andile.creditCards.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CardDTO {
    private String cardName;
    private double apr;
    private double eligibility;
}
