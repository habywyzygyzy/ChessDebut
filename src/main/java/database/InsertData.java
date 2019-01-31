package database;

import java.sql.SQLException;

import static singletons.DatabaseConfigSingleton.getStmt;

public class InsertData {
    public static void insertData() {
        String sql;
        try {
            sql = "INSERT INTO REGISTRATION VALUES (100, 'Zara', 'Ali',18)";
            getStmt().executeUpdate(sql);

            sql = "INSERT INTO REGISTRATION VALUES (101, 'Mahnaz', 'Fatma', 25)";
            getStmt().executeUpdate(sql);

            sql = "INSERT INTO REGISTRATION VALUES (102, 'Zaid', 'Khan', 30)";
            getStmt().executeUpdate(sql);

            sql = "INSERT INTO REGISTRATION VALUES (103, 'Sumit', 'Mittal', 28)";
            getStmt().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
