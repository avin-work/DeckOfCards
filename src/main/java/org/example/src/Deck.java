package org.example.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class Deck{
    private List<Card> cards = new ArrayList<>();

    public int getDeckSize(){
        return cards.size();
    }

    public List<Card> getCards(){
        return cards;
    }

    Deck(){
        for(Suit s : Suit.values()){
            for(Rank r : Rank.values()){
                cards.add(new Card(s,r));
            }
        }
    }

    public void shuffleCards(){
        Collections.shuffle(cards);
    }

    public Card drawCard(){
        int numberOfCards = cards.size();
        Card element = null;
        try{
            element = cards.get(numberOfCards-1);
        }catch(NoSuchElementException e){
            System.out.println("The Deck is empty!");
        }finally{
            cards.remove(numberOfCards-1);
        }
        return element;
    }

    public Card drawRandomCard(){
        Card element = null;

        //shuffle cards 5 times
        for(int i=0;i<5;i++){
            shuffleCards();
        }

        try{
            element = cards.getLast();
            cards.removeLast();
        }catch(NoSuchElementException e){
            System.out.println("The Deck is empty!");
        }
        return element;
    }

    public void displayCards(){
        for(Card card : cards){
            System.out.println(card);
        }
    }
}