package tools;

import singletons.FiltersSingleton;

import static database.DBConnection.openConnection;
import static database.ExecuteSQL.executeSQL;
import static java.lang.Boolean.TRUE;
import static singletons.ChessBoardSingleton.setIsWhiteMove;

public class Initialize {
    public static  void initialize(){
        openConnection();
        setIsWhiteMove(TRUE);
        executeSQL();
        FiltersSingleton.setMinELO(0);
        FiltersSingleton.setMinELO(0);
        FiltersSingleton.setName("");
        FiltersSingleton.setOpening("");
        FiltersSingleton.setYear(0);
    }
}
