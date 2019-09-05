package database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import static singletons.DatabaseConfigSingleton.getStmt;

public class ExecuteSQL {
    public static void executeSQL() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("mySQLWorkbench.sql"));
            StringBuilder sql = new StringBuilder(new String(""));
            String line;
            while ((line = reader.readLine()) != null) {
                sql.append(line);
            }
            getStmt().execute(String.valueOf(sql));
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}