import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Player> players = new ArrayList<>();
        players.add(new Player("Omer"));
        Blackjack blackjack = new Blackjack(players);
        blackjack.playRound();
    }
}
