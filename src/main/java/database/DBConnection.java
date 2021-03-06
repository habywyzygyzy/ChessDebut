package database;

import java.sql.DriverManager;
import java.sql.SQLException;

import static singletons.DatabaseConfigSingleton.*;

/**
 * Class that handles connection with database
 */
public class DBConnection {
    private static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/test;mode=mysql";

    private static final String USER = "sa";
    private static final String PASS = "";

    /**
     * Open connection with database
     */
    public static void openConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            setConn(DriverManager.getConnection(DB_URL, USER, PASS));
            setStmt(getConn().createStatement());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Close connection with database
     *
     * @throws SQLException Throws exception if could not close connection
     */
    public static void closeConnection() throws SQLException {
        try {
            if (getRs() != null)
                getRs().close();
            getStmt().close();
            getConn().close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (getStmt() != null) getStmt().close();
            try {
                if (getStmt() != null) getStmt().close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}