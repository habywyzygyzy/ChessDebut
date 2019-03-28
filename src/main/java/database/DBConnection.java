package database;

import singletons.DatabaseConfigSingleton;

import java.sql.DriverManager;
import java.sql.SQLException;

import static singletons.DatabaseConfigSingleton.*;

public class DBConnection {
    private static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/test";

    private static final String USER = "sa";
    private static final String PASS = "";

    public static void openConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");
            setConn(DriverManager.getConnection(DB_URL, USER, PASS));
            setStmt(getConn().createStatement());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection() {
        try {
            if (getRs() != null)
                getRs().close();
            getStmt().close();
            getConn().close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (getStmt() != null) getStmt().close();
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (getStmt() != null) getStmt().close();
            } catch (SQLException se) {
                se.printStackTrace();
            } //end finally try
        }
    }
}
