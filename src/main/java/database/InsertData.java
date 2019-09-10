package database;

import java.sql.SQLException;
import java.util.ArrayList;

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

    public static void insertIntoHit(String hit, ArrayList<Long> stateBeforeHit, int metaId) {
        String sql;
        String insert = "INSERT INTO `Hit`(Hit, StateBeforeHit,StateBeforeHit2, StateBeforeHit3, StateBeforeHit4,  MetaId) ";
        //String values = "VALUES ('" + hit + "','" + stateBeforeHit.get(0) + "','" + stateBeforeHit.get(1) + "','" + stateBeforeHit.get(2) + "','" + stateBeforeHit.get(3) + "','" + stateBeforeHit.get(4) + "','" + stateBeforeHit.get(5) + "','" + metaId + "')";
        String values = "VALUES ('" + hit + "','" + stateBeforeHit.get(0) + "','" + stateBeforeHit.get(1) + "','" + stateBeforeHit.get(2) + "','" + stateBeforeHit.get(3) + "','" + metaId + "')";

        try {
            sql = insert + values;
            getStmt().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
