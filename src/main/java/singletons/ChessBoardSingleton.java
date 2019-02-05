package singletons;

public class ChessBoardSingleton {
    private static String state;

    private ChessBoardSingleton(String state) {
        ChessBoardSingleton.state = state;
    }

    public static ChessBoardSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final ChessBoardSingleton INSTANCE = new ChessBoardSingleton(state);
    }

    public void setState(String boardState) {
        ChessBoardSingleton.state = boardState;
    }

    public String getState() {
        return ChessBoardSingleton.state;
    }
}
