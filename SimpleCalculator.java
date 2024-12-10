import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("What kind of operation would you like to perform? " +
        "\n1) Addition" +
        "\n2) Subtraction" +
        "\n3) Multiplication" + 
        "\n4) Division" +
        "\nEnter a number 1-4: ");

        int choice = scanner.nextInt();

        System.out.println();
        System.out.print("Enter your first number to calculate with: ");
        int num1 = scanner.nextInt();

        System.out.println();
        System.out.print("Enter your second number to calculate with: ");
        int num2 = scanner.nextInt();

        if(num2 == 0 && choice == 4)
        {
            while(num2 == 0)
            {
                System.out.print("You cannot divide by a zero. Enter a new number: ");
                num2 = scanner.nextInt();
            }
        }

        int sum = num1 + num2;
        int difference = num1 - num2;
        int product = num1 * num2;
        int quotient = num1 / num2;

        if(choice == 1)
        {
            System.out.println("Your two numbers added together equal " + sum);
        }
        else if(choice == 2)
        {
            System.out.println("Your two numbers subtracted from each other equal " + difference);
        }
        else if(choice == 3)
        {
            System.out.println("Your two numbers multiplied together equal " + product);
        }
        else if(choice == 4)
        {
            if(num2 == 0)
            {
                System.out.println("You cannot divide by 0");
            }
            else
            {
            System.out.println("Your two numbers divided together equal " + quotient);
            }
        }

        scanner.close();
    }
}
