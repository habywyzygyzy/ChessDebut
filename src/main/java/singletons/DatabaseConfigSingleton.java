package singletons;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Singleton that holds database configuration
 */
public class DatabaseConfigSingleton {
    private static Connection conn;
    private static Statement stmt;
    private static ResultSet rs;

    /**
     * @param conn Database Connection
     * @param stmt Statement to query the database
     * @param rs   Result Set for database
     */
    private DatabaseConfigSingleton(Connection conn, Statement stmt, ResultSet rs) {
        DatabaseConfigSingleton.conn = conn;
        DatabaseConfigSingleton.stmt = stmt;
        DatabaseConfigSingleton.rs = rs;
    }

    public static DatabaseConfigSingleton getInstance() {
        return DatabaseConfigSingleton.SingletonHolder.INSTANCE;
    }

    /**
     * Class that holds the instance of singleton
     */
    private static class SingletonHolder {
        private static final DatabaseConfigSingleton INSTANCE = new DatabaseConfigSingleton(conn, stmt, rs);
    }

    public static Connection getConn() {
        return conn;
    }

    public static void setConn(Connection conn) {
        DatabaseConfigSingleton.conn = conn;
    }

    public static Statement getStmt() {
        return stmt;
    }

    public static void setStmt(Statement stmt) {
        DatabaseConfigSingleton.stmt = stmt;
    }

    public static ResultSet getRs() {
        return rs;
    }

    public static void setRs(ResultSet rs) {
        DatabaseConfigSingleton.rs = rs;
    }
}
