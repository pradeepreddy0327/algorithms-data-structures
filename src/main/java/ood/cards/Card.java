package ood.cards;

public class Card {

    private Suit suit;
    private int rank;

    public Card(Suit suit, int rank) {
        super();
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Card [suit=" + suit + ", rank=" + rank + "]";
    }

}
