package com.andile.creditCards.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Card implements Comparable {

    private String provider;
    private String name;
    private double apr;
    private double cardScore;

    @JsonIgnore// since based on the Usecase ,the json body when we send our respose this field should not be visible so annotaion excludes it
    private double eligibility;

    @Override
    public int compareTo(Object o) { // method so that we can be able so sort our list
            Card c =((Card)o);
        if(this.cardScore>c.cardScore)
        {
            return 1;
        }
        if(this.cardScore< c.cardScore)
        {
            return -1;
        }
        return 0;
    }
}
