package vandyke.jack;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        //play function for replay
        Scanner playInput = new Scanner (System.in);
        boolean play = true;
        while (play) {
            //init game + get player name
            int attempt = 1;
            Scanner nameInput = new Scanner(System.in);
            String name = "";
            System.out.print("Hello player. What is your name? ");
            name = nameInput.nextLine();
            //generate random number
            int number;
            number = (int) (Math.random() * 20 + 1);
            //get player input
            Scanner guessInput = new Scanner(System.in);
            int playerGuess;
            System.out.println("Well, " + name + ", I'm thinking of a number between 1 and 20. You have six tries to guess it. Are you ready?");
            //game function
            do {
                System.out.print("Guess a number: ");
                if (guessInput.hasNextInt()) {
                    playerGuess = guessInput.nextInt();
                    //check player input
                    if (playerGuess == number) {
                        System.out.println("Congratulations " + name + ", your guess is correct. You guessed the number in " + attempt + " guesses.");
                        break;
                    } else if (playerGuess < number) {
                        System.out.println("Your guess is too low. Try again.");
                    } else if (playerGuess > number) {
                        System.out.println("Your guess is too high. Try again.");
                    }
                    if (attempt == 6) {
                        System.out.println("You took too many guesses and lost. Better luck next time.");
                        break;
                    }
                    attempt++;
                } else {
                    System.out.println("Enter a valid number, not whatever that was.");
                    break;
                }
            } while (playerGuess != number);
            System.out.println("Do you wish to play again? Y/N");
            String answer = playInput.nextLine();
            play = answer.equalsIgnoreCase("y");
        }
    }
}