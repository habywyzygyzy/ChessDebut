package database;

import static database.CreateTable.createTable;
import static database.InsertData.insertData;
import static database.PrintData.printData;

public class DBExecutor {
    public void Test() {
        long start = System.nanoTime();
        createTable();
        insertData();
        printData();
        long end = System.nanoTime() - start;
        System.out.println("Czas w ms pomiędzy otwarciem a zamknięciem " + end / 1000000);
        System.out.println("Goodbye!");
    }
}
