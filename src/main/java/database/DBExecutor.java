package database;

import static database.CreateTable.createTable;
import static database.InsertData.insertData;
import static database.PrintData.printData;

public class DBExecutor {
    public void Test() {
        createTable();
        insertData();
        printData();
        System.out.println("Goodbye!");
    }
}
