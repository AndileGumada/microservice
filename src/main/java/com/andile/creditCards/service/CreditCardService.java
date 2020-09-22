package com.andile.creditCards.service;

import com.andile.creditCards.dto.*;
import com.andile.creditCards.models.Card;
import com.andile.creditCards.models.PartnerOne;
import com.andile.creditCards.models.PartnerTwo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class CreditCardService {
    RestTemplate restTemplate =new RestTemplate();

    public ResponseEntity<?> getCreditCards(UserDTO userDTO){

        //partner1
        CsCardDto csCardDto=new CsCardDto();
        csCardDto.setName(userDTO.getName());
        csCardDto.setCreditScore(userDTO.getCreditScore());

        //partner 2
        ScoreCards scoreCards = new ScoreCards();
        scoreCards.setName(userDTO.getName());
        scoreCards.setSalary(userDTO.getSalary());
        scoreCards.setScore(userDTO.getCreditScore());

        ResponseDTO responseDTO = new ResponseDTO();
        List<PartnerOne> partnerOnes;
        List<PartnerTwo> partnerTwos;
        List<Card> cards = new ArrayList<>();


       partnerOnes =restTemplate.postForObject("https://app.clearscore.com/api/global/backend-tech-test/v1/cards",csCardDto,List.class);

        /*
         * Setting the provider so that we know who provided which cards and converting the two partnerOne into a card
         * since we know that creditcard is a card which is a parent they want us to return to the front end
         * adding this cards to a list of cards so that we can sort them
         *
         * */
        for(PartnerOne p: partnerOnes){
            System.out.println(p);
        }
        partnerOnes.stream().map(partner1 ->{
            Card card = new Card();
            card.setApr(partner1.getApr());
            card.setName(partner1.getCardName());
            card.setProvider("CSCards");
            card.setEligibility(partner1.getEligibility());
            return card;
            
        }).forEach(c->cards.add(c));

        partnerTwos =restTemplate.postForObject("https://app.clearscore.com/api/global/backend-tech-test/v2/creditcards",scoreCards,List.class);

        /*
        * Setting the provider so that we know who provided which cards and converting the two partnertwo into a card
        * since we know that creditcard is a card which is a parent they want us to return to the front end
        * adding this cards to a list of cards as we did with partnerOne so that we can sort them
        *
        * */
        partnerTwos.stream().map(partner2 ->{
           Card card = new Card();
           card.setApr(partner2.getApr());
           card.setName(partner2.getCard());
           card.setProvider("ScoredCards");
           card.setEligibility(partner2.getApprovalRating());
            return card;
        }).forEach(c->cards.add(c));


        List<Card> response =sortCards(cards);
        responseDTO.setMessage("List of partners");
        responseDTO.setObject(response);
        responseDTO.setStatues("200");

        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    private List<Card> sortCards (List<Card> cards){// this method should return the sorted scorecards
        List<Card> sortedCards= new ArrayList<>();

        try {
            for (Card card : cards) {
                Double sortingScore = card.getEligibility() / Math.pow(card.getApr(), 2);//getting a power of anumber
                card.setCardScore(sortingScore);
                sortedCards.add(card);// calculate score cards
            }
            Collections.sort(sortedCards);//sort the list based on scoreCards this will call comparable method in user
        }catch (Exception e) {
            e.printStackTrace();

        }
        return sortedCards;//for sorting logic
    }
}
