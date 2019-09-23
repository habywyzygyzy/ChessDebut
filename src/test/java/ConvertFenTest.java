import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.*;
import tools.ConvertFen;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ConvertFenTest {
    String fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNRwKQkq";
    long[] convertedFen;
    ConvertFen converter;

    @BeforeAll
    void setUp() {
        converter = new ConvertFen();
        convertedFen = converter.convert(fen);
    }

    @AfterAll
    void tearDown() {
        fen = "";
        converter = null;
    }

    @Test
    void convertFenShouldReturnTheSameValuesForTheSameFen() {
        long[] arrayOfLongs;
        String tempFEN = fen;
        arrayOfLongs = converter.convert(tempFEN);
        for (int i = 0; i < 4; i++) {
            assertEquals(arrayOfLongs[i], convertedFen[i]);
        }

    }
}