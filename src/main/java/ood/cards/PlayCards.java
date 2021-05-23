package ood.cards;

public class PlayCards {

    public static void main(String[] args) {
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();
        System.out.println(deck.toString());

        System.out.println(deck.draw());
        System.out.println(deck.draw());
        System.out.println(deck.draw());
        System.out.println(deck.draw());
        System.out.println(deck.draw());
    }

}
