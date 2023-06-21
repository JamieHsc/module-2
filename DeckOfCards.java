package module23;

import java.util.*;

public class DeckOfCards {

    // Define an enum to represent the suits
    enum Suit {
        CLUBS,
        DIAMONDS,
        HEARTS,
        SPADES
    }

    // Define a Card class with suit, value and name properties
    static class Card {
        Suit suit;
        int value;
        String name;

        Card(Suit suit, int value) {
            this.suit = suit;
            this.value = value;
            if (value == 1) {
                this.name = "Ace";
            } else if (value == 11) {
                this.name = "Jack";
            } else if (value == 12) {
                this.name = "Queen";
            } else if (value == 13) {
                this.name = "King";
            } else {
                this.name = Integer.toString(value);
            }
        }

        public String toString() {
            return this.name + " of " + this.suit;
        }
    }

    // Define a method to create a deck of cards


    // Define a custom comparator to sort by suit and numerical value
    static class SuitValueComparator implements Comparator<Card> {
        @Override
        public int compare(Card card1, Card card2) {
            // First sort by suit
            int suitCompare = card1.suit.compareTo(card2.suit);
            if (suitCompare != 0) {
                return suitCompare;
            }
            // Then sort by numerical value
            return Integer.compare(card1.value, card2.value);
        }
    }


}