package Blackjack.Players;

import Blackjack.Card;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    protected final String name;
    protected List<Card> hand;
    protected double balance;

    public Player(String name){
        this.name = name;
        hand = new ArrayList<>();
        balance = 1000;
    }

    public Player(String name, double balance){
        this.name = name;
        hand = new ArrayList<>();
        this.balance = balance;
    }

    public abstract double placeBet();
    public abstract int chooseOption(int size);

    public void getCard(Card card){
        hand.add(card);
    }

    // Blackjack
    public int countHand(){
        int count = 0, aceCount = 0;
        for(Card card : hand){
            int rank = card.getRank();
            if(rank == Card.ACE){
                count++;
                aceCount++;
            } else if (rank == Card.JACK || rank == Card.QUEEN || rank == Card.KING){
                count += 10;
            } else {
                count += rank;
            }
        }
        while(0 < aceCount--){
            if(count + 10 <= 21) count += 10;
        }

        return count;
    }

    public String showHand(){
        StringBuilder sb = new StringBuilder(name + " has ");
        for(int i = 0; i < hand.size()-1; i++){
            sb.append(hand.get(i).toString() + ", ");
        }

        sb.append("and " + hand.get(hand.size()-1));

        return sb.toString();
    }


    public void adjustBalance(double amount){
        balance += amount;
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hand=" + showHand() +
                ", money=" + balance +
                '}';
    }
}
