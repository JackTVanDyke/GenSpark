package vandyke.jack;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import vandyke.jack.GuessTheNumber;


class GuessTheNumberTest {

    GuessTheNumber guessTheNumber;

    @BeforeEach
    void setUp() {
        guessTheNumber = new GuessTheNumber();
    }
    @Test
    void checkName() {
        guessTheNumber.setName("Jack");
        assertEquals("Jack", guessTheNumber.checkName(), "checkName is messed up, yo");
    }

    @Test
    void checkPlayerGuess() {
        guessTheNumber.setPlayerGuess(5);
        assertEquals(5, guessTheNumber.checkPlayerGuess(), "checkPlayerGuess just aint right");
    }

    @AfterEach
    void tearDown() {
        System.out.println("No errors, it's all good homie");
    }
}