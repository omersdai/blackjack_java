package Blackjack;

import Blackjack.Players.HumanPlayer;
import Blackjack.Players.Player;

import java.util.ArrayList;
import java.util.List;

public class Blackjack {
    public final static int HIT   = 1;
    public final static int STAY = 2;

    private Deck deck;
    private Player dealer;
    private List<Player> players;
    Double[] bets;
    int round;


    public Blackjack(List<Player> players){
        deck = new Deck();
        dealer = new HumanPlayer("Dealer");
        this.players = new ArrayList<>(players);
        bets = new Double[players.size()];
        round = 0;
    }

    public void playRound(){
        int n = players.size();
        System.out.println("ROUND " + ++round);
        printColumn();
        for(int i = 0; i < n; i++){
            Player player = players.get(i);
            bets[i] = player.placeBet();
            System.out.println(player.getName() + " bet $" + bets[i]);
            printColumn();
        }

        for(Player player : players){
            dealCard(player, true);
            dealCard(player, true);
        }

        Card openCard = dealCard(dealer, true);
        Card hiddenCard = dealCard(dealer, false);

        printColumn();

        // Go around the table
        for(int i = 0; i < n; i++){
            ask(i);
            printColumn();
        }

        System.out.println(dealer.showHand());

        int dealerCount = dealer.countHand();
        if(dealerCount <= 16){
            dealCard(dealer, true);
            dealerCount = dealer.countHand();
        }
        if(dealerCount > 21){
            System.out.println(dealer.getName() + " busted with " + dealerCount);
        } else{
            System.out.println(dealer.getName() + " has " + dealerCount);
        }

        for(int i = 0; i < n; i++){
            Player player = players.get(i);
            int count = player.countHand();
            if(bets[i] == null) continue;
            if(21 < dealerCount || dealerCount < count){
                System.out.println(player.getName() + " won the round with " + count);
                giveMoney(i, 2);
            } else{
                System.out.println(player.getName() + " lost the round with " + count);
            }
            printColumn();
        }

    }

    private void ask(int idx){
        Player player = players.get(idx);
        System.out.println(player.getName() + "'s turn:");
        System.out.println(player.showHand());
        int count = player.countHand();
        if(count == 21){
            System.out.println(player.getName() + " got 21 and won the round!");
            giveMoney(idx, 1.5);
            return;
        }
        System.out.println("1. Hit");
        System.out.println("2. Stay");
        int option = player.chooseOption(2);
        while(option == HIT){
            dealCard(player, true);
            count = player.countHand();
            if (count >= 21) break;
            option = player.chooseOption(2);
        }

        if(count > 21){
            System.out.println(player.getName() + " busted with " + count);
            dealer.adjustBalance(bets[idx]);
            bets[idx] = null;
        }
        else if(player.countHand() == 21){
            System.out.println(player.getName() + " got 21 and won the round!");
            giveMoney(idx, 1.5);
        } else{
            System.out.println(player.getName() + " stayed with " + count);
        }
    }

    private Card dealCard(Player player, boolean faceUp){
        Card card = deck.draw();
        player.getCard(card);
        System.out.println(player.getName() + " drew " + (faceUp ? card : "a card face down"));
        return card;
    }

    private void giveMoney(int idx, double multiplier){
        if(bets[idx] == null) return;
        double earning = bets[idx] * multiplier;
        Player player = players.get(idx);
        dealer.adjustBalance(-earning);
        player.adjustBalance(earning);
        System.out.println(player.getName() + " earned $" + earning);
        bets[idx] = null;
    }

    private void printColumn(){
        System.out.println("=============================");
    }

}
