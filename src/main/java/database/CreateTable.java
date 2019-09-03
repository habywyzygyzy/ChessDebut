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
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Kamil\\Desktop\\ChessDebut\\mySQLWorkbench.sql"));
            StringBuilder sql = new StringBuilder(new String(""));
            String line;
            while ((line = reader.readLine()) != null) {
                sql.append(line);
            }
            getStmt().execute(String.valueOf(sql));
            System.out.println("Created table in given database...");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}