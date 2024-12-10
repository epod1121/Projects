import java.util.Scanner;

public class BasicDataStructures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of integers you want to enter: ");
        int length = scanner.nextInt();
        
        System.out.println();

        int[] numbers = new int[length];

        for(int i = 0; i < length; i++)
        {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();

            System.out.println();
        }

        int average = 0;
        int sum = 0;
        for(int i = 0; i < length; i++)
        {
            sum += numbers[i];
            average = sum / length;
        }

        System.out.println("The average is: " + average);

        scanner.close();
    }
}
