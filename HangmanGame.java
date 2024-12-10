import java.util.Scanner;

public class HangmanGame {
    private static final String[] WORDS = {"hangman", "java", "programming", "computer", "science"};
    private static final int MAX_TRIES = 6;

    public static void main(String[] args) {
        String wordToGuess = selectRandomWord();
        char[] guessedWord = new char[wordToGuess.length()];
        boolean[] guessedLetters = new boolean[26];
        int incorrectAttempts = 0;

        initializeGuessedWord(guessedWord);

        Scanner scanner = new Scanner(System.in);

        while (incorrectAttempts < MAX_TRIES && !isWordGuessed(guessedWord)) {
            displayHangman(incorrectAttempts);
            displayGuessedWord(guessedWord);

            System.out.print("Enter a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            if (!Character.isLetter(guess)) {
                System.out.println("Invalid input. Please enter a valid letter.");
                continue;
            }

            if (guessedLetters[guess - 'a']) {
                System.out.println("You already guessed that letter. Try again.");
                continue;
            }

            guessedLetters[guess - 'a'] = true;

            if (containsLetter(wordToGuess, guess)) {
                updateGuessedWord(wordToGuess, guessedWord, guess);
            } else {
                System.out.println("Incorrect guess. Try again.");
                incorrectAttempts++;
            }
        }

        if (isWordGuessed(guessedWord)) {
            System.out.println("Congratulations! You guessed the word: " + wordToGuess);
        } else {
            System.out.println("Sorry, you ran out of attempts. The correct word was: " + wordToGuess);
        }

        scanner.close();
    }

    private static String selectRandomWord() {
        return WORDS[(int) (Math.random() * WORDS.length)];
    }

    private static void initializeGuessedWord(char[] guessedWord) {
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }
    }

    private static void displayHangman(int incorrectAttempts) {
        System.out.println("Incorrect Attempts: " + incorrectAttempts);
    }

    private static void displayGuessedWord(char[] guessedWord) {
        System.out.print("Current Word: ");
        for (char c : guessedWord) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    private static boolean isWordGuessed(char[] guessedWord) {
        for (char c : guessedWord) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }

    private static boolean containsLetter(String word, char letter) {
        return word.indexOf(letter) != -1;
    }

    private static void updateGuessedWord(String word, char[] guessedWord, char letter) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                guessedWord[i] = letter;
            }
        }
    }
}