package database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import static singletons.DatabaseConfigSingleton.getStmt;

public class CreateTable {
    public static void createTable() {
        System.out.println("Creating table in given database...");
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Kamil\\Desktop\\INZ\\ChessDebut\\mySQLWorkbench.sql"));
            StringBuilder sql = new StringBuilder(new String(""));
            String line;
            while ((line = reader.readLine()) != null) {
                sql.append(line);
            }
            System.out.println(sql);
            getStmt().execute(String.valueOf(sql));
            /*String sql = "DROP TABLE  IF EXISTS REGISTRATION ";
            getStmt().executeUpdate(sql);
            sql = "CREATE TABLE  IF NOT EXISTS REGISTRATION " +
                    "(id INTEGER not NULL, " +
                    " first VARCHAR(255), " +
                    " last VARCHAR(255), " +
                    " age INTEGER, " +
                    " PRIMARY KEY ( id ))";
            getStmt().executeUpdate(sql);*/
            System.out.println("Created table in given database...");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
