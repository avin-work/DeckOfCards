package org.example.src;

import java.util.Objects;

public class Card {

    private Suit suit;
    private Rank rank;

    Card(Suit suit , Rank rank){
        this.suit = suit;
        this.rank = rank;
    }

    //getters
    public Suit getSuit(){ return this.suit; };
    public Rank getRank(){ return this.rank; };

    //setters
    public void setSuit(Suit suit){
        this.suit = suit;
    }
    public void setRank(Rank rank){
        this.rank = rank;
    }

    @Override
    public String toString(){
        if(suit == Suit.SPADES){ return "♠ - " + rank; }
        if(suit == Suit.CLUBS){ return "♣ - " + rank; }
        if(suit == Suit.HEARTS){ return "♥ - " + rank; }
        if(suit == Suit.DIAMONDS){ return "♦ - " + rank; }
        return "";
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        return (((Card) obj).rank == rank) && (((Card) obj).suit == suit);
    }

    @Override
    public int hashCode(){
        return Objects.hash(suit, rank);
    }
}

enum Suit{
    HEARTS(1), DIAMONDS(2), CLUBS(3), SPADES(4);

    private int suit;

    Suit(int suit) { this.suit = suit; }
}

enum Rank{
    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13);

    private int rank;

    Rank(int rank){
        this.rank = rank;
    }
}

