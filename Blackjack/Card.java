package Blackjack;

import java.util.Map;

import static java.util.Map.entry;

public class Card {

    // Kinds of suits
    public final static int DIAMONDS = 1;
    public final static int CLUBS    = 2;
    public final static int HEARTS   = 3;
    public final static int SPADES   = 4;

    private final static Map<Integer, String> suitMap = Map.of(
            DIAMONDS, "Diamonds",
            CLUBS, "Clubs",
            HEARTS, "Hearts",
            SPADES, "Spades"
    );

    public final static int[] SUITS = {DIAMONDS, CLUBS, HEARTS, SPADES};

    // Kinds of ranks
    public final static int ACE   = 1;
    public final static int TWO = 2;
    public final static int THREE = 3;
    public final static int FOUR  = 4;
    public final static int FIVE  = 5;
    public final static int SIX   = 6;
    public final static int SEVEN = 7;
    public final static int EIGHT = 8;
    public final static int NINE  = 9;
    public final static int TEN   = 10;
    public final static int JACK  = 11;
    public final static int QUEEN = 12;
    public final static int KING  = 13;

    private final static Map<Integer, String> rankMap = Map.ofEntries(
            entry(ACE, "Ace"),
            entry(TWO, "2"),
            entry(THREE, "3"),
            entry(FOUR, "4"),
            entry(FIVE, "5"),
            entry(SIX, "6"),
            entry(SEVEN, "7"),
            entry(EIGHT, "8"),
            entry(NINE, "9"),
            entry(TEN, "10"),
            entry(JACK, "Jack"),
            entry(QUEEN, "Queen"),
            entry(KING, "King")
    );

    public final static int[] RANKS = {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING};
    
    
    private final int suit;
    private final int rank;

    public Card(int suit, int rank){
        this.suit = suit;
        this.rank = rank;
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "[" + rankMap.get(rank) + " of " + suitMap.get(suit) + "]";
    }
}
