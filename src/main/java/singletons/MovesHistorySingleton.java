package singletons;

import java.util.ArrayList;

/**
 * Singleton that holds history of moves made by user
 */
public class MovesHistorySingleton {

    private static StringBuilder moves;
    private static int fullMovesCounter;

    /**
     * @param moves            Moves history
     * @param fullMovesCounter Number of full moves that were made
     */
    private MovesHistorySingleton(StringBuilder moves, int fullMovesCounter) {
        MovesHistorySingleton.moves = moves;
        MovesHistorySingleton.fullMovesCounter = fullMovesCounter;
    }

    public static MovesHistorySingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * Class that holds the instance of singleton
     */
    private static class SingletonHolder {
        private static final MovesHistorySingleton INSTANCE = new MovesHistorySingleton(moves, fullMovesCounter);
    }

    public static StringBuilder getMoves() {
        return MovesHistorySingleton.moves;
    }

    public static void setMoves(StringBuilder moves) {
        MovesHistorySingleton.moves = moves;
    }

    public static int getFullMovesCounter() {
        return MovesHistorySingleton.fullMovesCounter;
    }

    public static void setFullMovesCounter(int fullMovesCounter) {
        MovesHistorySingleton.fullMovesCounter = fullMovesCounter;
    }
}
