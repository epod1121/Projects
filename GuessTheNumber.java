import java.util.*;

public class GuessTheNumber 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int num = generateNum();
        int numGuessed = -1;
        
        while (numGuessed != num)
        {
            System.out.print("Guess the number (0-100): ");
            numGuessed = input.nextInt();
            System.out.println();

            check(num, numGuessed);

            if (num == numGuessed) {
                System.out.println("Congratulations! You guessed the number!");
            }
        }
        
        input.close();
    }

    //generate number
    public static int generateNum() 
    {
        Random rand = new Random();

        int randNum = rand.nextInt(100);

        return randNum;
    }

    //check
    public static void check(int num, int guess)
    {
        if(num < guess)
        {
            System.out.println("Too high. Guess again.");
        }
        else if(num > guess)
        {
            System.out.println("Too low. Guess again.");
        }
    }
}
