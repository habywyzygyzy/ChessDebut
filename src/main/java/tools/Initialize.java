package tools;

import singletons.ChessBoardSingleton;

import static database.DBConnection.openConnection;
import static database.ExecuteSQL.executeSQL;
import static java.lang.Boolean.TRUE;
import static singletons.ChessBoardSingleton.setIsWhiteMove;
import static singletons.FiltersSingleton.*;

public class Initialize {
    public static void initialize() {
        openConnection();
        setIsWhiteMove(TRUE);
        executeSQL();
        setMinELO(0);
        setMaxELO(0);
        setName("");
        setOpening("");
        setYear(0);
        String[][] emptyState = new String[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                emptyState[i][j] = "";
            }
        }
        ChessBoardSingleton.getInstance().setState(emptyState);
    }
}
