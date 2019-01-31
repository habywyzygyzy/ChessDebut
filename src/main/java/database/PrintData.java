package database;

import java.sql.SQLException;

import static singletons.DatabaseConfigSingleton.*;

public class PrintData {
    public static void printData() {
        String sql;
        sql = "SELECT id, first, last, age FROM REGISTRATION";
        try {
            setRs(getStmt().executeQuery(sql));
            System.out.println("Result set");
            while (getRs().next()) {
                //Retrieve by column name
                int id = getRs().getInt("id");
                int age = getRs().getInt("age");
                String first = getRs().getString("first");
                String last = getRs().getString("last");
                //Display values
                System.out.print("ID: " + id);
                System.out.print(", Age: " + age);
                System.out.print(", First: " + first);
                System.out.println(", Last: " + last);
            }
            System.out.println("After While");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
