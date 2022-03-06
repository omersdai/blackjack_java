package Blackjack.Players;

import java.util.Scanner;

public class HumanPlayer extends Player{
    private final static Scanner sc = new Scanner(System.in);

    public HumanPlayer(String name) {
        super(name);
    }

    public HumanPlayer(String name, double balance){
        super(name, balance);
    }

    public double placeBet(){
        balance -= 31;
        return 31;
//        System.out.println(name + "\tBalance: $" + balance);
//        System.out.print("Place your bet: ");
//        double bet = sc.nextDouble();
//
//        while(bet < 0 || balance < bet){
//            System.out.println("Enter a valid bet: ");
//            bet = sc.nextDouble();
//        }
//        balance -= bet;
//        return bet;
    }

    public int chooseOption(int size){
        System.out.print("Choose an option: ");
        int option = sc.nextInt();
        while(option < 1 || option >  size){
            System.out.print("Choose an option between 1 and " + size + ": ");
            option = sc.nextInt();
        }
        return option;
    }
}
