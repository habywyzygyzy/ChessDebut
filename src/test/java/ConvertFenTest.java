import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools.ConvertFen;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class ConvertFenTest {
    String FEN;
    ConvertFen converter;
    @Before
    void setUp() {
        FEN = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNRwKQkq";

    }

    @After
    void tearDown() {
    }

    @Test
    void convert() {
    }
}