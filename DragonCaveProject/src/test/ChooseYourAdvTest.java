import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import vandyke.jack.ChooseYourAdv;

class ChooseYourAdvTest {
    ChooseYourAdv chooseYourAdv;

    @BeforeEach
    void setUp() {
        chooseYourAdv = new ChooseYourAdv();
    }

    @Test
    void getHand() {
        chooseYourAdv.setHand(1);
        assertEquals(1, chooseYourAdv.getHand(), "This better be 1 lol.");
    }

    @AfterEach
    void tearDown() {
        System.out.println("No errors.. IT'S ALL GOOD.");
    }
}