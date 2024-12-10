import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Blackjack {

    private static int MONEY = 100;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Blackjack!\n");

        int choice;
        
        do {
            ArrayList<Integer> cards = new ArrayList<>();
            ArrayList<Integer> computerCards = new ArrayList<>();
            int cardSum = cards.stream().mapToInt(Integer::intValue).sum();

            System.out.println("You current balance: $" + MONEY);

            System.out.print("The cards are: ");
            generateRandNum(cards);

            do {
                System.out.println("\n\n1) Hit\n2) Stand\n3) Quit");
                System.out.print("Enter the number of the action you would like to perform: ");
                choice = input.nextInt();

                if (choice == 1 && cardSum <= 21) {
                    hitCard(cards);
                } else if (choice == 2 || cardSum > 21) {
                    computer(computerCards);
                    checkForWinner(cards, computerCards);
                }


            } while (choice != 3 && MONEY >= 0);

        } while (MONEY >= 0);

        input.close();
    }

    public static void generateRandNum(ArrayList<Integer> cards) {
        Random rand = new Random();

        for (int i = 0; i < 2; i++) {
            int randNum = rand.nextInt(0, 12);
            cards.add(randNum);
        }

        System.out.print(cards);
    }

    public static void hitCard(ArrayList<Integer> cards) {
        Random rand = new Random();
        int randNum = rand.nextInt(1, 12);
        cards.add(randNum);
        System.out.print("\nYour cards are: ");
        System.out.print(cards);
    }

    public static void computer(ArrayList<Integer> computerCards) {
        System.out.println("\nComputer's turn!");

        Random rand = new Random();

        for (int i = 0; i < 2; i++) {
            int randNum = rand.nextInt(1, 12);
            computerCards.add(randNum);
        }

        System.out.print("Computer's cards: ");
        System.out.print(computerCards);

        int sum = 0;

        for (int i = 0; i < computerCards.size(); i++) {
            sum += computerCards.get(i);
        }

        while (sum < 17) {
            System.out.println("\n\nThe computer hits.");

            int randNum = rand.nextInt(1, 12);
            computerCards.add(randNum);

            System.out.print("Computer's cards: ");
            System.out.println(computerCards);

            sum += randNum;
        }
        
    }

    public static void checkForWinner(ArrayList<Integer> cards, ArrayList<Integer> computerCards) {
        int cardSum = cards.stream().mapToInt(Integer::intValue).sum();
        int computerSum = computerCards.stream().mapToInt(Integer::intValue).sum();


        if(cardSum <= 21 && computerSum > 21){
            System.out.println("\nGambler wins!");
            MONEY += 25;
            System.out.println("You current balance: $" + MONEY);
        } else if(computerSum <= 21 && cardSum > 21){
            System.out.println("\nComputer wins!");
            MONEY -= 25;
            System.out.println("You current balance: $" + MONEY);
        } else if (computerSum == 21 && cardSum == 21){
            System.out.println("Tie!");
            MONEY += 10;
        } else if (computerSum > 21 && cardSum > 21){
            System.out.println("Both bust!");
            MONEY -= 25;
            System.out.println("You current balance: $" + MONEY);
        }
    }
}