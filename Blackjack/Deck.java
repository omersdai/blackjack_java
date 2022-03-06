package Blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    private List<Card> deck;
    private final Random rand;

    public Deck(){
        deck = new ArrayList<>(Card.SUITS.length * Card.RANKS.length);
        rand = new Random();

        for(int suit : Card.SUITS){
            for(int rank : Card.RANKS){
                deck.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle(){
        int n = deck.size();
        List<Card> shuffledDeck = new ArrayList<>(n);

        for(int i = 0; i < n; i++){
            Card card = draw();
            shuffledDeck.add(card);
        }

        deck = shuffledDeck;
    }

    public Card draw(){
        int idx = rand.nextInt(deck.size());
        Card card = deck.get(idx);
        deck.set(idx, deck.get(deck.size()-1));
        deck.remove(deck.size()-1);
        return card;
    }

    public void addCards(List<Card> cards){
        deck.addAll(cards);
    }

    @Override
    public String toString() {
        return deck.toString();
    }
}
