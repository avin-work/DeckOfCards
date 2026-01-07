package org.example.src;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class MainTest {
    Deck deck = new Deck();

    @Test
    public void checkDeckSize(){
        assert(52 == deck.getDeckSize());
    }

    @Test
    public void checkUniquenessOfCards() {
        HashSet<String> set = new HashSet<>();

        List<Card> cards = deck.getCards();

        for (Card card : cards) {
            set.add(card.toString());
        }
        assert(set.size() == 52);
    }

    @Test
    public void checkSortedOrder(){
        Card kingHearts = new Card(Suit.HEARTS, Rank.KING);
        Card twoHearts = new Card(Suit.HEARTS, Rank.TWO);
        Card aceSpades = new Card(Suit.SPADES, Rank.ACE);

        Card[] cards = {kingHearts, twoHearts, aceSpades};

        List<Card> cardsSorted = Arrays.stream(cards)
                .sorted(Comparator.comparing(Card::getSuit)
                .thenComparing(Card::getRank))
                .toList();

        List<Card> expectedOrder = List.of(twoHearts, kingHearts, aceSpades);
        boolean flag;
        for(int i=0;i<3;i++) {
            if (cardsSorted.get(i) != expectedOrder.get(i)){
                flag = false;
                assert(flag);
                return;
            }
        }
        flag = true;
        assert(flag);
    }


}
