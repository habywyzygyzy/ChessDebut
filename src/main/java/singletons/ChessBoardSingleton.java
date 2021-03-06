package singletons;

/**
 * Singleton that contains current board state
 */
public class ChessBoardSingleton {

    private static String[][] state;
    private static Boolean isWhiteMove;
    private static Boolean whiteCastlingDone;
    private static Boolean blackCastlingDone;

    /**
     * @param state Current chessboard state
     * @param isWhiteMove Flag that shows which player has the move now
     * @param whiteCastlingDone Flag that shows if white player have done catling
     * @param blackCastlingDone Flag that shows if black player have done catling
     */
    private ChessBoardSingleton(String[][] state, Boolean isWhiteMove, Boolean whiteCastlingDone, Boolean blackCastlingDone) {
        ChessBoardSingleton.state = state;
        ChessBoardSingleton.isWhiteMove = isWhiteMove;
    }

    public static ChessBoardSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }


    /**
     * Class that holds the instance of singleton
     */
    private static class SingletonHolder {
        private static final ChessBoardSingleton INSTANCE = new ChessBoardSingleton(state, isWhiteMove, whiteCastlingDone, blackCastlingDone);
    }

    public void setState(String[][] boardState) {
        ChessBoardSingleton.state = boardState;
    }

    public String[][] getState() {
        return ChessBoardSingleton.state;
    }

    public static Boolean getIsWhiteMove() {
        return ChessBoardSingleton.isWhiteMove;
    }

    public static void setIsWhiteMove(Boolean isWhiteMove) {
        ChessBoardSingleton.isWhiteMove = isWhiteMove;
    }

    public static Boolean getWhiteCastlingDone() {
        return whiteCastlingDone;
    }

    public static void setWhiteCastlingDone(Boolean whiteCastlingDone) {
        ChessBoardSingleton.whiteCastlingDone = whiteCastlingDone;
    }

    public static void setBlackCastlingDone(Boolean blackCastlingDone) {
        ChessBoardSingleton.blackCastlingDone = blackCastlingDone;
    }

    public static Boolean getBlackCastlingDone() {
        return blackCastlingDone;
    }
}
