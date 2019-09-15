package tools;

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
    }
}
