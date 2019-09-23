import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools.ConvertFen;
import tools.FenHandler;

public class FenHandlerTest {
    String fen;

    @BeforeEach
    public void setUp() {
        fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
    }

    @AfterEach
    public void tearDown() {
        fen = "";
    }

    @Test
    public void removeWhiteSpacesShouldRemoveThemFromString() {
        fen = FenHandler.removeWhiteSpaces(fen);
        Assert.assertEquals("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNRwKQkq", fen);
    }
}
