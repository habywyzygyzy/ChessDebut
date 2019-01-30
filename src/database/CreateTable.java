package database;

import java.sql.SQLException;

import static singletons.DatabaseConfigSingleton.*;
import static singletons.DatabaseConfigSingleton.getStmt;

public class CreateTable {
    public static void CreateTable() {
        System.out.println("Creating table in given database...");
        try {
            setStmt(getConn().createStatement());
            String sql = "DROP TABLE  IF EXISTS REGISTRATION ";
            getStmt().executeUpdate(sql);
            sql = "CREATE TABLE  IF NOT EXISTS REGISTRATION " +
                    "(id INTEGER not NULL, " +
                    " first VARCHAR(255), " +
                    " last VARCHAR(255), " +
                    " age INTEGER, " +
                    " PRIMARY KEY ( id ))";
            getStmt().executeUpdate(sql);
            System.out.println("Created table in given database...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
