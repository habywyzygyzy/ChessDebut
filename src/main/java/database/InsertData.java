package database;

import java.sql.SQLException;

import static singletons.DatabaseConfigSingleton.getStmt;

public class InsertData {
    public static void insertData() {
        String sql;
        try {
            sql = "INSERT INTO `mydb`.`MetaData` VALUES ('WHITE')";
            getStmt().executeUpdate(sql);

            sql = "INSERT INTO `mydb`.`MetaData` VALUES ('BLACK')";
            getStmt().executeUpdate(sql);

            sql = "INSERT INTO `mydb`.`MetaData` VALUES ('BLACK')";
            getStmt().executeUpdate(sql);

            sql = "INSERT INTO `mydb`.`MetaData` VALUES ('WHITE')";
            getStmt().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
