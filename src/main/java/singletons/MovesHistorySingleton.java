package singletons;

import java.util.ArrayList;

public class MovesHistorySingleton {

    private static ArrayList<String> moves;

    private MovesHistorySingleton(ArrayList<String> moves) {
        MovesHistorySingleton.moves = moves;
    }

    public static MovesHistorySingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final MovesHistorySingleton INSTANCE = new MovesHistorySingleton(moves);
    }

    public static ArrayList<String> getMoves() {
        return MovesHistorySingleton.moves;
    }

    public static void setMoves(ArrayList<String> moves) {
        MovesHistorySingleton.moves = moves;
    }
}
