package com.company;

public class Card {
    public enum Suit {
        SPADES("Piki"), HEARTS("Kier"), DIAMONDS("Karo"), CLUBS("Trefl");
        private final String name;
        Suit(String name) { this.name = name; }
        public String getName() { return name; }
    }

    public enum Rank {
        TWO(0, "2"), THREE(0, "3"), FOUR(0, "4"), FIVE(0, "5"), SIX(0, "6"),
        SEVEN(0, "7"), EIGHT(0, "8"), NINE(0, "9"), TEN(0, "T"),
        JACK(1, "J"), QUEEN(2, "Q"), KING(3, "K"), ACE(4, "A");

        private final int points;
        private final String symbol;

        Rank(int points, String symbol) {
            this.points = points;
            this.symbol = symbol;
        }

        public int getPoints() { return points; }
        public String getSymbol() { return symbol; }
    }

    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() { return suit; }
    public Rank getRank() { return rank; }

    @Override
    public String toString() {
        return rank.getSymbol();
    }
}