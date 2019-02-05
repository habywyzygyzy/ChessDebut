package singletons;

public class ChessBoardSingleton {
    private static String state;

    private static Boolean isWhiteMove;

    private ChessBoardSingleton(String state, Boolean isWhiteMove) {
        ChessBoardSingleton.state = state;
        ChessBoardSingleton.isWhiteMove = isWhiteMove;
    }

    public static ChessBoardSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final ChessBoardSingleton INSTANCE = new ChessBoardSingleton(state, isWhiteMove);
    }

    public void setState(String boardState) {
        ChessBoardSingleton.state = boardState;
    }

    public String getState() {
        return ChessBoardSingleton.state;
    }

    public static Boolean getIsWhiteMove() {
        return ChessBoardSingleton.isWhiteMove;
    }

    public static void setIsWhiteMove(Boolean isWhiteMove) {
        ChessBoardSingleton.isWhiteMove = isWhiteMove;
    }
}
