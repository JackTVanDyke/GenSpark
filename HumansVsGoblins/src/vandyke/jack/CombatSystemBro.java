package vandyke.jack;

import java.util.Scanner;

public class CombatSystemBro {
    private final int DICE_SIDES = 20;
    private final int HUMAN_MIN_HIT_PERCENTAGE = 30;
    private final int GOBLIN_MIN_HIT_PERCENTAGE = 40;
    private Scanner scanner;

    public CombatSystemBro(Scanner scanner) {
        this.scanner = scanner;
    }

    public int[] commenceBattle(Human player) {
        Goblin goblin = new Goblin();
        goblin.setX(player.getX());
        goblin.setY(player.getY());

        while (goblin.getHealth() > 0 && player.getHealth() > 0) {

            int humanRoll = (int) (Math.random() * DICE_SIDES) + 1; // equivalent to a 20 sided dice roll.
            int goblinRoll = (int) (Math.random() * DICE_SIDES) + 1; // equivalent to a 20 sided dice roll.
            int hitPercentage = (int) ((Math.random() * DICE_SIDES) + 1) * 5; // Generates a hit percentage between 5 and 100.
            int goblinStartingHealth = goblin.getHealth();
            int humanStartingHealth = player.getHealth();

            if (humanRoll > goblinRoll) {
                if ((hitPercentage) > HUMAN_MIN_HIT_PERCENTAGE) {
                    System.out.println("\nYou try to attack the goblin");
                    System.out.println("AND YOU'RE SUCCESSFUL!");
                    goblin = (Goblin) player.attack(goblin);
                    int damageDealt = goblinStartingHealth - goblin.getHealth();
                    System.out.println("You deal " + damageDealt + " damage to your enemy.");
                    System.out.println("The little dude has " + goblin.getHealth() + "health remaining.\n");
                    HumansVsGoblinsLogic.sleep(2000);
                } else {
                    System.out.println("\nYou try to attack the goblin.");
                    System.out.println("but you MISS!");
                    System.out.println("It looks relieved.\n");
                    HumansVsGoblinsLogic.sleep(2000);

                }
            } else {
                if ((hitPercentage) > GOBLIN_MIN_HIT_PERCENTAGE) {
                    System.out.println("\nThe goblin tries to attack you, ");
                    System.out.println("AND THEY'RE SUCCESSFUL!");
                    player = (Human) goblin.attack(player);
                    int damageDealt = humanStartingHealth - player.getHealth();
                    System.out.println("They deal " + damageDealt + " damage to you.");
                    System.out.println("You have " + player.getHealth() + " health remaining.\n");
                    HumansVsGoblinsLogic.sleep(2000);
                } else {
                    System.out.println("\n The goblin tries to attack you, ");
                    System.out.println("but they MISS!");
                    System.out.println("You give a sigh of relief.\n");
                    HumansVsGoblinsLogic.sleep(2000);
                }
            }
            if (player.getHealth() <= 0) {
                System.out.println("Hahaha you actually died, wow!");
                System.out.println("Game Over...");
                HumansVsGoblinsLogic.sleep(2000);
                System.exit(0); // Ends game if player dies.

            } else if (goblin.getHealth() <= 0) {
                System.out.println("You really killed it, huh. What if it had a family?");
                System.out.println("You step over the lifeless corpse and continue on like a psychopath.");
                HumansVsGoblinsLogic.sleep(2000);
                break;
            }
            if (!fleeOrBattle()) {
                System.out.println("You run away like a scaredy cat.");
                System.out.println(player.getName() + " lives to die another day!\n");
                HumansVsGoblinsLogic.sleep(2000);
                return new int[]{goblin.getX(), goblin.getY()};
            }
        }
        return null;
    }
    private boolean fleeOrBattle() {
        System.out.println("Fight or flee?\n");
        String battleChoice = "";
        while (!battleChoice.equals("flee") && !battleChoice.equals("fight"))
            try {
                battleChoice = scanner.nextLine().toLowerCase();
            } catch (Exception e) {
                e.printStackTrace();
            }
        return !battleChoice.equals("flee");
    }
}

