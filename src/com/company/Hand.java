package com.company;

import java.util.HashMap;
import java.util.List;

public class Hand {
    private List<Card> cards;

    public Hand(List<Card> cards) {
        this.cards = cards;
    }

    public int calculateTotalPoints() {
        int figurePoints = 0;

        for (Card card : cards) {
            figurePoints += card.getRank().getPoints();
        }

        HashMap<Card.Suit, Integer> counts = new HashMap<>();
        for (Card card : cards) {
            Card.Suit suit = card.getSuit();
            if (counts.containsKey(suit)) {
                counts.put(suit, counts.get(suit) + 1);
            } else {
                counts.put(suit, 1);
            }
        }

        int distPoints = 0;
        for (Card.Suit suit : Card.Suit.values()) {
            int count = 0;
            if (counts.get(suit) != null) {
                count = counts.get(suit);
            }

            if (count == 0) distPoints += 3;
            else if (count == 1) distPoints += 2;
            else if (count == 2) distPoints += 1;
            else if (count > 4) distPoints += (count - 4);
        }

        return figurePoints + distPoints;
    }

    public String getCardsBySuit(Card.Suit suit) {
        StringBuilder sb = new StringBuilder();
        for (Card card : cards) {
            if (card.getSuit() == suit) {
                sb.append(card.toString());
            }
        }
        return sb.toString();
    }
}