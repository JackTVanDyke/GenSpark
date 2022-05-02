package vandyke.jack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameLogicTest {

    GameLogic gameLogic;

    @BeforeEach
    void setUp(){
        gameLogic = new GameLogic();
    }
    @Test
    void getWordToFind(){
        gameLogic.setWordToFind("CAT");
        assertEquals("CAT", gameLogic.getWordToFind(), "word to find is messed up");
    }

    @Test
    void getNumberWrongGuess() {
        gameLogic.setNumWrongGuess(5);
        assertEquals(5, gameLogic.getNumWrongGuess(), "number wrong guess is broken");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Tests Complete");
    }

}