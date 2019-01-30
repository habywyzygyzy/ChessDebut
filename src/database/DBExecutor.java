package database;

import java.sql.*;

import static database.CreateTable.*;
import static database.DBConnection.CloseConnection;
import static database.DBConnection.OpenConnection;
import static database.InsertData.*;
import static database.PrintData.*;
import static singletons.DatabaseConfigSingleton.*;

public class DBExecutor {
    public void Test() {
        long start = System.nanoTime();
        OpenConnection();
        CreateTable();
        InsertData();
        PrintData();
        CloseConnection();
        long end = System.nanoTime() - start;
        System.out.println("Czas w ms pomiędzy otwarciem a zamknięciem " + end / 1000000);
        System.out.println("Goodbye!");
    }
}
