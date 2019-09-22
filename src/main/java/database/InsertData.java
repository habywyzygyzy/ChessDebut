package database;

import java.sql.SQLException;

import static singletons.DatabaseConfigSingleton.getStmt;

public class InsertData {

    public static void insertIntoMetaData(String winner, int gameYear, String opening, String whiteName, String blackName, int whiteELO, int blackELO) {
        String sql;
        try {
            String insert = "INSERT INTO `MetaData`(`Result`, `GameYear`, `Opening`, `WhiteName`, `BlackName`, `WhiteELO`, `BlackELO`) ";
            String values = "VALUES ('" + winner + "','" + gameYear + "','" + opening + "','" + whiteName + "','" + blackName + "','" + whiteELO + "','" + blackELO + "')";
            sql = insert + values;
            getStmt().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertIntoHit(String hit, long[] stateBeforeHit, int metaId) {
        String sql;
        String insert = "INSERT INTO `Hit`(`Hit`, `StateBeforeHit`, `StateBeforeHit2`, `StateBeforeHit3`, `StateBeforeHit4`,  `MetaId`) ";
        String values = "VALUES ('" + hit + "','" + stateBeforeHit[0] + "','" + stateBeforeHit[1] + "','" + stateBeforeHit[2] + "','" + stateBeforeHit[3] + "','" + metaId + "')";

        try {
            sql = insert + values;
            getStmt().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
