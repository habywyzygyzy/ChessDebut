package database;

import java.sql.SQLException;

import static singletons.DatabaseConfigSingleton.getStmt;

public class InsertData {

    public static void insertIntoMetaData(String winner) {
        String sql;
        try {
            sql = "INSERT INTO `MetaData`(Result) VALUES ('" + winner + "')";
            getStmt().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertIntoHit(String hit, double stateBeforeHit) {
        String sql;
        try {
            sql = "INSERT INTO `Hit`(Hit,StateBeforeHit) VALUES ('" + hit + "','" + stateBeforeHit + "')";
            getStmt().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
