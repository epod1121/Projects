import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Yahtzee{

    public static int aces = 0;    
    public static int twos = 0;
    public static int threes = 0;
    public static int fours = 0;
    public static int fives = 0;
    public static int sixes = 0;
    public static int threeKind = 0;
    public static int fourKind = 0;
    public static int fullHouse = 0;
    public static int smallStraight = 0;
    public static int largeStraight = 0;
    public static int yahtzee = 0;

    public static ArrayList<Integer> nums = new ArrayList<>();

    public static boolean canScore = true;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Yahtzee!\n\n");
        
        rollTheDice();

        while(aces == 0 || twos == 0 || threes == 0 || fours == 0 || fives == 0 || sixes == 0 || 
        threeKind == 0 || fourKind == 0 || fullHouse == 0 || smallStraight == 0 || largeStraight == 0 || yahtzee == 0)
        {
            System.out.println("=======================================\n");
            userInput(input);
        }

        int totalGameScore = aces + twos + threes + fours + fives + sixes + threeKind + fourKind + fullHouse + smallStraight + largeStraight + yahtzee;
        System.out.println("\nGame over! Your final score is " + totalGameScore + ".\n\nThanks for playing!");

        input.close();
    }

    //roll the dice
    public static void rollTheDice(){
        Random rand = new Random();
        
        System.out.print("The dice you rolled: ");

        for(int i = 0; i < 5; i++)
        {
            int numRolled = rand.nextInt(6) + 1;
            nums.add(numRolled);
            System.out.print(numRolled + ", ");
        }

        System.out.println();
        System.out.println();
    }

    //get user input
    public static void userInput(Scanner input){
        System.out.print("1) Reroll All Dice" +
        "\n2) Fill In Score Sheet" +
        "\n3) View Your Score Sheet" +
        "\nEnter which action you would like to perform: ");
        int choice = input.nextInt();

        System.out.println();

        if (choice == 1) {
            System.out.println("=======================================\n");
            nums.clear();
            rollTheDice();
            canScore = true;
        }
        else if (choice == 2 && canScore) {
            chooseField(input);
            canScore = false;
        }
        else if (choice == 3) {
            scoreSheetDisplay();
        }
        else{
            System.out.println("\nNot an option.");
        }
    }

    //reroll select dice
    //public static void selectDiceThenReroll(){}

    //view score sheet
    public static void scoreSheetDisplay(){

        System.out.print("Aces: " + aces + "            " + "Three of a Kind: " + threeKind +
        "\nTwos: " + twos + "            " + "Four of a Kind: " + fourKind +
        "\nThrees: " + threes + "          " + "Full House: " + fullHouse +
        "\nFours: " + fours + "           " + "Small Straight: " + smallStraight +
        "\nFives: " + fives + "           " + "Large Straight: " + largeStraight +
        "\nSixes: " + sixes + "           " + "Yahtzee: " + yahtzee + "\n");
    }

    //select which field to put numbers in
    public static void chooseField(Scanner input){
        System.out.print("1)Aces" + "            " + "7)Three of a Kind" +
        "\n2)Twos" + "            " + "8)Four of a Kind" +
        "\n3)Threes" + "          " + "9)Full House" +
        "\n4)Fours" + "           " + "10)Small Straight" +
        "\n5)Fives" + "           " + "11)Large Straight" +
        "\n6)Sixes" + "           " + "12)Yahtzee" +
        "\nEnter the number corresponding with the feild you want to fill in: ");
        int choice = input.nextInt();
        gameScore(choice);
    }

    //total
    public static void gameScore(int num){
        switch (num) {
            case 1:
                if (aces == 0) {
                    for (int i = 0; i < nums.size(); i++) {
                        if (nums.get(i) == 1) {
                            aces++;
                        }
                    }
                } else {
                    System.out.println("\nField already filled");
                }
                break;

            case 2:
                if (twos == 0) {
                    for (int i = 0; i < nums.size(); i++) {
                        if (nums.get(i) == 2) {
                            twos += 2;
                        }
                    }
                } else {
                    System.out.println("\nField already filled");
                }
                break;

            case 3:
                if(threes == 0){
                    for(int i = 0; i < nums.size(); i++){
                        if(nums.get(i) == 3){
                            threes += 3;
                        }
                    }
                } else{
                    System.out.println("\nField already filled");
                }
                break;
            
            case 4:
                if(fours == 0){
                    for(int i = 0; i < nums.size(); i++){
                        if(nums.get(i) == 4){
                            fours += 4;
                        }
                    }
                } else{
                    System.out.println("\nField already filled");
                }
                break;

            case 5: 
                if(fives == 0){
                    for(int i = 0; i < nums.size(); i++){
                        if(nums.get(i) == 5){
                            fives += 5;
                        }
                    }
                } else {
                    System.out.println("\nField already filled");
                }
                break;
            
            case 6: 
                if(sixes == 0){
                    for(int i = 0; i < nums.size(); i++){
                        if(nums.get(i) == 6){
                            sixes += 6;
                        }
                    }
                } else{
                    System.out.println("\nField already filled");
                }
                break;

            case 7:
                if(threeKind == 0)
                    for(int i : nums)
                        threeKind += i;
                else{
                    System.out.println("\nField already filled");
                }
                break;

            case 8:
                if(fourKind == 0)
                    for(int i : nums)
                        fourKind += i;
                else{
                    System.out.println("\nField already filled");
                }
                break;

            case 9:
                if(fullHouse == 0)
                    fullHouse = 25;
                else{
                    System.out.println("\nField already filled.");
                }
                break;
            
            case 10:
                if(smallStraight == 0)
                    smallStraight = 30;
                else{
                    System.out.println("\nField already filled.");
                }
                break;

            case 11: 
                if(largeStraight == 0)
                    largeStraight = 40;
                else{
                    System.out.println("\nField already filled.");
                }
                break;
            
            case 12:
                if(yahtzee == 0)
                    yahtzee = 50;
                else{
                    System.out.println("\nField already filled.");
                }
                break;
        
            default: System.out.println("Invalid input.");
                break;
        }
    }
}