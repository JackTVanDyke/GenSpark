package vandyke.jack;
import java.util.Scanner;

public class ChooseYourAdv {
    public static void main(String[] args) {
        Scanner playerInput = new Scanner(System.in);
        String answer;

        // Enter choice and receive consequence
        System.out.println("You come across a wizard by the side of the road. Or maybe a monk. Or maybe just an old person. " +
                "Who knows. Anyways, he offers you a choice. You can choose to receive an item he's holding in one of his hands, but only one. " +
                "What will you choose? His left hand or his right? (INPUT L OR R)");
        answer = playerInput.nextLine();

        if (answer.equals("L")) {
            System.out.println("You receive a crumpled up tissue. It's crusty. How nice.");
        } else if (answer.equals("R")) {
            System.out.println("You receive a 'Magic Bean' from the wizard. You eat the bean, only to wake up and find yourself without clothes. How magical.");
        } else {
            System.out.println("The 'wizard' becomes enraged by your indecision and proceeds to stab you. He may just be homeless.");
        }
    }
}
