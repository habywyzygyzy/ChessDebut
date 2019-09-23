package tools;

import singletons.ChessBoardSingleton;
import singletons.MovesHistorySingleton;

import java.util.Arrays;

import static database.DBConnection.openConnection;
import static database.ExecuteSQL.executeSQL;
import static java.lang.Boolean.TRUE;
import static singletons.ChessBoardSingleton.*;
import static singletons.ChessBoardSingleton.setIsWhiteMove;
import static singletons.FiltersSingleton.*;
import static singletons.MovesHistorySingleton.*;

/**
 * Initialize data
 */
public class Initialize {
    /**
     * Set up all necessary data, create tables, open database connection
     */
    public static void initialize() {
        openConnection();
        executeSQL();
        setIsWhiteMove(TRUE);
        setMinELO(0);
        setMaxELO(0);
        setName("");
        setOpening("");
        setYear(0);
        setFullMovesCounter(1);
        setMoves(new StringBuilder(""));
        ChessBoardSingleton.getInstance().setState(initialBoardState());
    }

    /**
     * @return Initial state of the chess board
     */
    private static String[][] initialBoardState() {
        String[][] initialState = new String[8][8];
        for (int i = 0; i < 8; i++) {
            Arrays.fill(initialState[i], "");
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (i) {
                    case 0: {
                        switch (j) {
                            case 0:
                            case 7:
                                initialState[i][j] = "r";
                                break;
                            case 1:
                            case 6:
                                initialState[i][j] = "n";
                                break;
                            case 2:
                            case 5:
                                initialState[i][j] = "b";
                                break;
                            case 3:
                                initialState[i][j] = "q";
                                break;
                            case 4:
                                initialState[i][j] = "k";
                                break;
                        }

                        break;
                    }
                    case 1:
                        initialState[i][j] = "p";
                        break;
                    case 6:
                        initialState[i][j] = "P";
                        break;
                    case 7: {
                        switch (j) {
                            case 0:
                            case 7:
                                initialState[i][j] = "R";
                                break;
                            case 1:
                            case 6:
                                initialState[i][j] = "N";
                                break;
                            case 2:
                            case 5:
                                initialState[i][j] = "B";
                                break;
                            case 3:
                                initialState[i][j] = "Q";
                                break;
                            case 4:
                                initialState[i][j] = "K";
                                break;
                        }
                        break;
                    }
                }
            }
        }
        return initialState;
    }
}
