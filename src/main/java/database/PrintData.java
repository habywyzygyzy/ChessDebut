package database;

import java.sql.SQLException;

import static singletons.DatabaseConfigSingleton.*;

public class PrintData {
    public static void printData() {
        String sql = "SELECT MetaId, Result FROM `mydb`.`MetaData`";
        try {
            setRs(getStmt().executeQuery(sql));
            while (getRs().next()) {
                //Retrieve by column name
                int id = getRs().getInt("MetaId");
                String first = getRs().getString("Result");
                //Display values
                System.out.print("ID: " + id);
                System.out.print(", First: " + first);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
