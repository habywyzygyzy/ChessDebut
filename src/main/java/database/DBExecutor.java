package database;

import tools.StringToDouble;

import static database.CreateTable.createTable;
import static database.InsertData.*;

public class DBExecutor {
    public void Test() {
        createTable();
        insertIntoMetaData("White");
        insertIntoHit("e4", StringToDouble.convert("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNRwKQkq"));
        System.out.println("Goodbye!");
    }
}
