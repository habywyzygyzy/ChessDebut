package tools;

import static singletons.ChessBoardSingleton.*;

public class FenHandler {
    public static String translateBoardToFEN(String[][] board) {
        String fen = "";
        Boolean whiteShortCastling, whiteLongCastling, blackShortCastling, blackLongCastling;
        whiteShortCastling = whiteLongCastling = blackShortCastling = blackLongCastling = Boolean.TRUE;
        for (int rank = 0; rank < board.length; rank++) {
            int empty = 0;
            StringBuilder rankFen = new StringBuilder();
            for (int file = 0; file < board[rank].length; file++) {
                if (board[rank][file].length() == 0) {
                    empty++;
                } else {
                    if (empty != 0) rankFen.append(empty);
                    rankFen.append(board[rank][file]);
                    empty = 0;
                }
            }
            if (empty != 0) rankFen.append(empty);
            fen += rankFen;
            if (!(rank == board.length - 1)) {
                String RANK_SEPARATOR = "/";
                fen += RANK_SEPARATOR;
            }
        }
        if (getIsWhiteMove())
            fen += "w";
        else
            fen += "b";
        if (getWhiteCastlingDone())
            whiteShortCastling = whiteLongCastling = Boolean.FALSE;
        if (getBlackCastlingDone())
            blackShortCastling = blackLongCastling = Boolean.FALSE;

        if (blackShortCastling)
            fen += "K";
        if (blackLongCastling)
            fen += "Q";
        if (whiteShortCastling)
            fen += "k";
        if (whiteLongCastling)
            fen += "q";
        if (!blackLongCastling && !whiteLongCastling && !blackShortCastling && !whiteShortCastling)
            fen += "-";
        return fen;
    }

    public static String removeWhiteSpaces(String fen) {
        String newStr = "";
        if (fen.contains("-"))
            newStr = fen.substring(0, fen.indexOf("-") + 1);
        if (fen.contains("KQkq"))
            newStr = fen.substring(0, fen.lastIndexOf("KQkq") + 4);
        else if (fen.contains("KQ"))
            newStr = fen.substring(0, fen.lastIndexOf("KQ") + 2);
        else if (fen.contains("kq"))
            newStr = fen.substring(0, fen.lastIndexOf("kq") + 2);

        return newStr.replaceAll("\\s+", "");
    }
}
