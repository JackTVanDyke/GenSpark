package vandyke.jack;
import java.util.Scanner;

public class ChooseYourAdv {

    private int hand;

    public void runIt() {
        Scanner playerInput = new Scanner(System.in);
        gameDialogue();
        hand = getPlayerInput(playerInput);
        gameAnswer();

    }

    private void gameDialogue() {
        System.out.println("You come across a wizard by the side of the road. Or maybe a monk. Or maybe just an old person. " +
                "Who knows. Anyways, he offers you a choice. You can choose to receive an item he's holding in one of his hands, but only one. " +
                "What will you choose? His left hand or his right? (INPUT 1 OR 2)");
    }

    private int getPlayerInput(Scanner playerInput) {
        int hand = 0;
        while (hand != 1 && hand != 2) {

            try {
                int choice = playerInput.nextInt();
                if (choice == 1 || choice == 2)
                    hand = choice;
                else {
                    System.out.println("The 'wizard' is waiting. (INPUT 1 OR 2)");
                    playerInput.nextLine();
                }
            } catch (Exception e) {
                System.out.println("The 'wizard' is waiting. (INPUT 1 OR 2)");
                playerInput.nextLine();
            }
        }
        return hand;
    }

    private void gameAnswer() {
            if (hand == 1) {
                System.out.println("You receive a crumpled up tissue. It's crusty. How nice.");
            } else if (hand == 2) {
                System.out.println("You receive a 'Magic Bean' from the wizard. You eat the bean, only to wake hours later and find yourself without clothes. How magical.");
            }
        }

    public int getHand() {
        return hand;
    }

    public void setHand(int hand) {
        this.hand = hand;
    }
}

