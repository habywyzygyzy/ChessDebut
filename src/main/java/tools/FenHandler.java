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
        String newString = fen;
        String board;
        String meta;
        int spaceIndex = newString.indexOf(" ");
        board = newString.substring(0, spaceIndex);
        meta = newString.substring(spaceIndex);

        if (meta.contains("-"))
            meta = meta.substring(0, meta.indexOf("-") + 1);

        if (meta.contains("KQkq"))
            meta = meta.substring(0, meta.indexOf("KQkq") + 4);

        else if (meta.contains("KQk"))
            meta = meta.substring(0, meta.indexOf("KQk") + 3);

        else if (meta.contains("KQq"))
            meta = meta.substring(0, meta.indexOf("KQq") + 3);

        else if (meta.contains("Qkq"))
            meta = meta.substring(0, meta.indexOf("Qkq") + 3);

        else if (meta.contains("Kk"))
            meta = meta.substring(0, meta.indexOf("Kk") + 2);

        else if (meta.contains("Qq"))
            meta = meta.substring(0, meta.indexOf("Qq") + 2);

        else if (meta.contains("Kq"))
            meta = meta.substring(0, meta.indexOf("Kq") + 2);

        else if (meta.contains("Qk"))
            meta = meta.substring(0, meta.indexOf("Qk") + 2);

        else if (meta.contains("KQ"))
            meta = meta.substring(0, meta.indexOf("KQ") + 2);

        else if (meta.contains("k"))
            meta = meta.substring(0, meta.indexOf("k") + 1);

        else if (meta.contains("q"))
            meta = meta.substring(0, meta.indexOf("q") + 1);

        else if (meta.contains("K"))
            meta = meta.substring(0, meta.indexOf("K") + 1);

        else if (meta.contains("Q"))
            meta = meta.substring(0, meta.indexOf("Q") + 1);

        meta = meta.replaceAll("\\s", "");
        newString = board + meta;
        return newString;
    }
}
