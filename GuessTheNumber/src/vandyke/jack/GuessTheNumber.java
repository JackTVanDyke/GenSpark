package vandyke.jack;
import java.util.Scanner;

public class GuessTheNumber {
    private String name;
    private int randNum;
    private int attempt;
    int playerGuess;
    private Scanner nameInput = new Scanner(System.in);
    private Scanner guessInput = new Scanner(System.in);

    public GuessTheNumber() {
        randNum = (int) (Math.random() * 20) + 1;
        attempt = 1;
        name = "";
    }

    public void runGame() {
        name = getNameInput();
        gameDialogue();
        playerGuess = getPlayerGuess();
        testPlayerGuess();
    }

    private String getNameInput() {
        System.out.print("Hello player. What is your name? ");
        try {
            name = nameInput.nextLine();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return name;
    }

    private void gameDialogue() {
        System.out.println("Well, " + name + ", I'm thinking of a number between 1 and 20. You have six tries to guess it. Are you ready?");
        try {
            while(!guessInput.hasNextInt()) {
                System.out.println("Enter a number between 1 and 20. Come on, it's not that hard.");
                guessInput.nextLine();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private int getPlayerGuess() {
        try {
            playerGuess = guessInput.nextInt();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return playerGuess;
    }

    private void testPlayerGuess() {
        boolean validGuess = true;
        while (playerGuess != randNum && attempt < 6) {
           if (validGuess) {
               if (playerGuess > randNum) {
                   System.out.println("Your guess is too high. Try again.");
                   attempt++;
               } else if (playerGuess < randNum) {
                   System.out.println("Your guess is too low. Try again.");
                   attempt++;
                   }
               }
           try {
               playerGuess = guessInput.nextInt();
               validGuess = true;
           } catch (Exception e) {
               System.out.println("What on earth are you doing? Guess a NUMBER BETWEEN 1 AND 20. Come on, it's easy.");
               validGuess = false;
               guessInput.nextLine();
           }

           if (playerGuess == randNum) {
               System.out.println("Congratulations " + name + ", your guess is correct. You guessed the number in " + attempt + " guesses.");
           } else if (attempt == 6) {
               System.out.println("You took too many guesses and lost. Better luck next time.");
           }
        }
    }


    public String checkName() {
        return name;
    }

    public int checkPlayerGuess() {
        return playerGuess;
    }

    public void setPlayerGuess(int playerGuess) {
        this.playerGuess = playerGuess;
    }

    public void setName(String name) {
        this.name = name;
    }

}

