package vandyke.jack;

import java.util.HashMap;

public class Land {
    private final int ROWS = 20;
    private final int COLUMNS = 20;
    protected final char[][] map;
    protected final HashMap<String, Integer> playerLocation;
    private int numGoblins = (int) (Math.random() * 10) + 5;

    public Land() {
        map = new char[ROWS][COLUMNS];
        playerLocation = new HashMap<>();
        createStartingMap();
        determineGoblinSpawn();
        determinePlayerSpawn();
        printAndCheckMap();
    }

    private void createStartingMap() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                map[i][j] = '-';
            }
        }
    }

    private void determineGoblinSpawn() {
        for (int i = 0; i < numGoblins; i++) {
            int row = (int) (Math.random() * ROWS);
            int column = (int) (Math.random() * COLUMNS);
            if (map[row][column] == 'G') {
                i--;
            } else {
                map[row][column] = 'G';
            }
        }
    }

    public void addGoblin(int[] coordinates) {

        map[coordinates[0]][coordinates[1]] = 'G';
    }

    private void determinePlayerSpawn() {
        for (int i = 0; i < 1; i++) {
            int row = (int) (Math.random() * ROWS);
            int column = (int) (Math.random() * COLUMNS);

            if (map[row][column] != 'G') {
                map[row][column] = '@';
                playerLocation.put("x", row);
                playerLocation.put("y", column);
            } else {
                i--;
            }
        }
    }

    public boolean mapCleared() {
        boolean isMapPopulated = false;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (map[i][j] == 'G') {
                    isMapPopulated = true;
                    break;
                }
            }
        }
        return isMapPopulated;
    }

    public boolean printAndCheckMap() {
        System.out.println();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        return mapCleared();
    }


}

