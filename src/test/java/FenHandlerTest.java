import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.*;
import tools.ConvertFen;
import tools.FenHandler;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FenHandlerTest {
    String fen;

    @BeforeAll
    public void setUp() {
        fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
    }

    @AfterAll
    public void tearDown() {
        fen = "";
    }

    @Test
    public void removeWhiteSpacesShouldRemoveThemFromString() {
        fen = FenHandler.removeWhiteSpaces(fen);
        Assert.assertEquals("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNRwKQkq", fen);
    }
}
