package vandyke.jack;

import java.util.HashMap;
import java.util.Scanner;

public class HumansVsGoblinsLogic {
    private Land land;
    private Human player;
    private Scanner scanner;
    private CombatSystemBro combatSystemBro;

    public HumansVsGoblinsLogic() {
        startGame();
    }

    public void startGame() {
        scanner = new Scanner(System.in);
        introText();
        player = generateHuman();
        instructionsText();
        land = new Land();
        combatSystemBro = new CombatSystemBro(scanner);
        player.setX(getPlayerLocation().get("x"));
        player.setY(getPlayerLocation().get("y"));
        gameLoop();
    }

    private void introText() {
        System.out.println("\nHUMANS VERSUS GOBLINS");
        System.out.println("Hello Adventurer. What Is Your Name? \n");
    }

    private void instructionsText() {
        System.out.println("Your character is marked with @. Goblins are marked with G. Defeat all the goblins to win.");
        System.out.println("N is North, S is South, E is East, W is West, and Q is to Quit.");
    }

    private void promptMovement() {
        System.out.println("\nWhere would you like to go?");
        System.out.println("N, S, E, or W?  Q to quit.");
    }

    public HashMap<String, Integer> getPlayerLocation() {
        return land.playerLocation;
    }

    public char updatePlayerLocation(int x, int y, int movedX, int movedY) {
        char tileType = '-';
        if (land.map[movedX][movedY] == 'G') {
            tileType = land.map[movedX][movedY];
        }
        land.map[movedX][movedY] = '@';
        land.map[x][y] = '-';
        land.playerLocation.replace("x", x, movedX);
        land.playerLocation.replace("y", y, movedY);
        return tileType;
    }

    public void updatePlayerLocation(int x, int y) {
        land.map[x][y] = '@';
        land.playerLocation.replace("x", x);
        land.playerLocation.replace("y", y);
    }

    private char playerMovement(String dir) {
        int x = player.getX();
        int y = player.getY();
        char tile = '-';

        switch (dir) {
            case "N" -> {
                if (x-1 >= 0) {
                    tile = updatePlayerLocation(x, y, x-1, y);
                    player.setX(getPlayerLocation().get("x"));
                    player.setY(getPlayerLocation().get("y"));
                }
            }
            case "S" -> {
                if (x+1 < 20) {
                    tile = updatePlayerLocation(x, y, x+1, y);
                    player.setX(getPlayerLocation().get("x"));
                    player.setY(getPlayerLocation().get("y"));
                }
            }
            case "W" -> {
                if (y+1 < 20) {
                    tile = updatePlayerLocation(x, y, x, y-1);
                    player.setX(getPlayerLocation().get("x"));
                    player.setY(getPlayerLocation().get("y"));
                }
            }
            case "E" -> {
                if (y-1 >= 0 ) {
                    tile = updatePlayerLocation(x, y, x, y+1);
                    player.setX(getPlayerLocation().get("x"));
                    player.setY(getPlayerLocation().get("y"));
                }
            }
        }
        return tile;
    }

    private void playerMovement(int x, int y) {
        updatePlayerLocation(x, y);
        player.setX(x);
        player.setY(y);
    }

    private void gameLoop() {
        String playerInput = "";
        while (true) {
            while (!playerInput.matches("[NSEWQ]")) {
                promptMovement();
                try {
                    playerInput = scanner.nextLine().toUpperCase();
                } catch (Exception e) {
                    playerInput = "Q";
                }
            }
            if (playerInput.equals("Q")) {
                break;
            }
            char tileOn = playerMovement(playerInput);
            if (tileOn == 'G') {
                land.printAndCheckMap();
                System.out.println("\nYou come upon a Goblin wandering the forest.. or cave.. or maybe mine? Uhh.. It's uh, the terrain.. yes, we'll go with terrain for all these -'s.");
                System.out.println("The goblin, wandering the local terrain, attacks you!");
                sleep(1000);
                int[] coordinates = combatSystemBro.commenceBattle(player);
                if (coordinates != null) {
                    land.addGoblin(coordinates);
                    updatePlayerLocation(player.getPrevX(), player.getPrevY());
                }
                if (!land.printAndCheckMap()) {
                    sleep(2000);
                    System.out.println("\nCongratulations, " + player.getName() + ", you killed all those helpless goblins. Good job.");
                    System.exit(0);
                }
                playerInput = "";
            }
            if (tileOn == '-') {
                land.printAndCheckMap();
                playerInput = "";
            }
        }
    }

    public static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Human generateHuman() {

        String name = "";

        while (name.equals("")) {
            try {
                name = scanner.nextLine();

            } catch (Exception e) {
                System.out.println("A fatal error has occurred.  Game will now restart.");
                name = "q";
                startGame();
            }
        }
        return new Human(name);
    }
}
