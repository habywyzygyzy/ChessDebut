package database;

import static database.CreateTable.createTable;

public class DBExecutor {
    public void Test() {
        createTable();
        //insertData();
        //printData();
        System.out.println("Goodbye!");
    }
}
