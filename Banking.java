import java.util.Scanner;

public class Banking {

    private static int MONEY = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Hello! Welcome to the bank.");
        
        int choice = 0;
        
        while(choice != 4){
            choice = getInput(input);

            if (choice == 1) {
                check();
            }
            else if (choice == 2) {
                deposit(input);
            }
            else if (choice == 3) {
                withdraw(input);
            }
            else if (choice == 4) {
                System.out.println("Goodbye.");
            }
            else{
                System.out.println("Not an option. Try again.");
                System.out.println();
            }
        }

        input.close();
    }

    //user input
    public static int getInput(Scanner input){
        
        System.out.print(
        "\n1) Check balance" + 
        "\n2) Deposit money" + 
        "\n3) Withdraw money" + 
        "\n4) Leave Bank" +
        "\nHow can I help you today? ");

        int choice = input.nextInt();

        System.out.println();

        return choice;
    }

    //deposit money
    public static void deposit(Scanner input){

        System.out.print("Deposit amount: ");
        int amount = input.nextInt();

        MONEY += amount;

        System.out.println("New account balance: " + MONEY);
        System.out.println();
    }

    //withdraw money
    public static void withdraw(Scanner input){

        System.out.print("Withdraw amount: ");
        int amount = input.nextInt();

        if ((MONEY - amount) < 0) {
            System.out.println("You do not have enough money.");
            System.out.println();
        }
        else{
            MONEY -= amount;
            System.out.println("New account balance: " + MONEY);
            System.out.println();
        }
    }

    //check balance
    public static void check(){
        System.out.println("Your current account balance: " + MONEY);
        System.out.println();
    }
}
