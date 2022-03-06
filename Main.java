import Blackjack.Blackjack;
import Blackjack.Players.HumanPlayer;
import Blackjack.Players.Player;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Player> players = new ArrayList<>();
        players.add(new HumanPlayer("Omer"));
        Blackjack blackjack = new Blackjack(players);
        while (true){
            blackjack.playRound();
        }

    }
}
