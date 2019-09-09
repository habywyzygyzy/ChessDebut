package tools;

import java.util.Arrays;

import static singletons.ChessBoardSingleton.*;

public class FenHandler {
    public static String translateBoardToFEN(String[][] board) {
        String fen = "";
        Boolean whiteShortCastling, whiteLongCastling, blackShortCastling, blackLongCastling;
        whiteShortCastling = whiteLongCastling = blackShortCastling = blackLongCastling = Boolean.TRUE;
        for (int rank = 0; rank < board.length; rank++) {
            // count empty fields
            int empty = 0;
            // empty string for each rank
            StringBuilder rankFen = new StringBuilder();
            for (int file = 0; file < board[rank].length; file++) {
                if(board[rank][file].length() == 0) {
                    empty++;
                } else {
                    // add the number to the fen if not zero.
                    if (empty != 0) rankFen.append(empty);
                    // add the letter to the fen
                    rankFen.append(board[rank][file]);
                    // reset the empty
                    empty = 0;
                }
            }
            // add the number to the fen if not zero.
            if (empty != 0) rankFen.append(empty);
            // add the rank to the fen
            fen += rankFen;
            // add rank separator. If last then add a space
            if (!(rank == board.length-1)) {
                String RANK_SEPARATOR = "/";
                fen += RANK_SEPARATOR;
            }
        }
        if (getIsWhiteMove())
            fen += "w";
        else
            fen += "b";
        System.out.println(Arrays.toString(board[0]));
        System.out.println(Arrays.toString(board[7]));
        if(getWhiteCastlingDone())
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
        if(!blackLongCastling && !whiteLongCastling && !blackShortCastling && !whiteShortCastling)
            fen += "-";
        return fen;
    }
    public static String removeWhiteSpaces(String fen) {
        String newStr = "";
        if (fen.contains("-"))
            newStr = fen.substring(0, fen.indexOf("-")+1);
        if (fen.contains("KQkq"))
            newStr = fen.substring(0, fen.lastIndexOf("KQkq")+4);
        else if (fen.contains("KQ"))
            newStr = fen.substring(0, fen.lastIndexOf("KQ")+2);
        else if (fen.contains("kq"))
            newStr = fen.substring(0, fen.lastIndexOf("kq")+2);

        String stringWithoutSpaces = newStr.replaceAll("\\s+", "");
        return stringWithoutSpaces;
    }
}
