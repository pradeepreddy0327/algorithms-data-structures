package ood.cards;

import java.util.Arrays;
import java.util.Random;

public class DeckOfCards {

    private static final int NCARDS = 52;
    private static final int CARDS_IN_SUIT = 13;
    private static final int SHUFFLE_TIMES = 1000;

    private Card[] deck;
    private int drawIndex;

    public DeckOfCards() {
        this.deck = new Card[NCARDS];
        int i = 0;
        for (Suit s : Suit.values()) {
            for (int j = 1; j <= CARDS_IN_SUIT; j++) {
                deck[i++] = new Card(s, j);
            }
        }
    }

    public void shuffle() {
        Random random = new Random();
        for (int i = 0; i < SHUFFLE_TIMES; i++) {
            // get random indexes
            int j = random.nextInt(NCARDS);
            int k = random.nextInt(NCARDS);

            // swap
            Card temp = deck[j];
            deck[j] = deck[k];
            deck[k] = temp;
        }
    }

    public Card draw() {
        return deck[drawIndex++];
    }

    @Override
    public String toString() {
        return "DeckOfCards [deck=" + Arrays.toString(deck) + "]";
    }

}
