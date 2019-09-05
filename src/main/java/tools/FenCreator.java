package tools;

import java.util.Arrays;

import static singletons.ChessBoardSingleton.*;

public class FenCreator {
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

        if (!board[0][0].equals("r") || !board[0][1].isEmpty() || !board[0][2].isEmpty() || !board[0][3].isEmpty() || !board[0][4].equals("k")) {
            blackLongCastling = Boolean.FALSE;
        }
        if (!board[7][0].equals("R") || !board[7][1].isEmpty() || !board[7][2].isEmpty() || !board[7][3].isEmpty() || !board[7][4].equals("K")) {
            whiteLongCastling = Boolean.FALSE;
        }
        if (!board[0][7].equals("r") || !board[0][6].isEmpty() || !board[0][5].isEmpty() || !board[0][4].equals("k")) {
            blackShortCastling = Boolean.FALSE;
        }
        if (!board[7][7].equals("R") || !board[7][6].isEmpty() || !board[7][5].isEmpty() || !board[7][4].equals("K")) {
            whiteShortCastling = Boolean.FALSE;
        }
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
}
