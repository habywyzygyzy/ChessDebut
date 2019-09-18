package singletons;

import models.Statistics;

import java.util.ArrayList;

public class MovesHistorySingleton {

    private static ArrayList<String> moves;
    private static ArrayList<Integer> rows;
    private static ArrayList<Integer> columns;

    private MovesHistorySingleton(ArrayList<String> moves, ArrayList<Integer> rows, ArrayList<Integer> columns) {
        MovesHistorySingleton.moves = moves;
        MovesHistorySingleton.rows = rows;
        MovesHistorySingleton.columns = columns;
    }

    public static MovesHistorySingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final MovesHistorySingleton INSTANCE = new MovesHistorySingleton(moves, rows, columns);
    }

    public static ArrayList<String> getMoves() {
        return MovesHistorySingleton.moves;
    }

    public static void setMoves(ArrayList<String> moves) {
        MovesHistorySingleton.moves = moves;
    }

    public static ArrayList<Integer> getRows() {
        return MovesHistorySingleton.rows;
    }

    public static void setRows(ArrayList<Integer> rows) {
        MovesHistorySingleton.rows = rows;
    }

    public static ArrayList<Integer> getColumns() {
        return MovesHistorySingleton.columns;
    }

    public static void setColumns(ArrayList<Integer> columns) {
        MovesHistorySingleton.columns = columns;
    }
}
