package database;

import tools.StringToDouble;

import java.sql.SQLException;

import static singletons.DatabaseConfigSingleton.getStmt;

public class InsertData {
    /*public static void insertData() {
        String sql;
        try {
            sql = "INSERT INTO `MetaData`(Result) VALUES ('WHITE')";
            getStmt().executeUpdate(sql);

            sql = "INSERT INTO `MetaData`(Result) VALUES ('BLACK')";
            getStmt().executeUpdate(sql);

            sql = "INSERT INTO `MetaData`(Result) VALUES ('BLACK')";
            getStmt().executeUpdate(sql);

            sql = "INSERT INTO `MetaData`(Result) VALUES ('WHITE')";
            getStmt().executeUpdate(sql);

            String temp = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNRwKQkq";
            double value = StringToDouble.convert(temp);
            System.out.println(StringToDouble.convert(temp));
            System.out.println(value);
            sql = "INSERT INTO `Hit`(StateBeforeHit) VALUES ('"+value+"')";
            getStmt().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    public static void insertIntoMetaData(String winner) {
        String sql;
        try {
            sql = "INSERT INTO `MetaData`(Result) VALUES ('"+winner+"')";
            getStmt().executeUpdate(sql);

            sql = "INSERT INTO `MetaData`(Result) VALUES ('"+winner+"')";
            getStmt().executeUpdate(sql);

            sql = "INSERT INTO `MetaData`(Result) VALUES ('"+winner+"')";
            getStmt().executeUpdate(sql);

            sql = "INSERT INTO `MetaData`(Result) VALUES ('"+winner+"')";
            getStmt().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertIntoHit(String hit, double stateBeforeHit) {
        String sql;
        try {
            sql = "INSERT INTO `Hit`(Hit,StateBeforeHit) VALUES ('"+hit+"','"+stateBeforeHit+"')";
            getStmt().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
