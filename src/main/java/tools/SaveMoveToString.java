package tools;

import singletons.ChessBoardSingleton;
import singletons.MovesHistorySingleton;

import java.util.ArrayList;

public class SaveMoveToString {
    public static String saveMoveToString(ArrayList<String> differences, ArrayList<Integer> rows, ArrayList<Integer> cols) {
        char[] colLabel = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        char[] rowLabel = {'8', '7', '6', '5', '4', '3', '2', '1'};
        StringBuilder stringMove = new StringBuilder();
        for (int i = 0; i < differences.size(); i++) {
            if (differences.get(i).toUpperCase().contains("P")
                    || differences.get(i).toUpperCase().contains("R")
                    || differences.get(i).toUpperCase().contains("N")
                    || differences.get(i).toUpperCase().contains("B")
                    || differences.get(i).toUpperCase().contains("Q")
                    || differences.get(i).toUpperCase().contains("K")) {
                if (differences.get(i).toUpperCase().contains("P"))
                    differences.set(i, differences.get(i).replaceAll("[Pp]", ""));
                if (ChessBoardSingleton.getIsWhiteMove()) {
                    stringMove.
                            append(" ").
                            append(MovesHistorySingleton.getFullMovesCounter()).
                            append(".").
                            append(" ").
                            append(differences.get(i)).
                            append(colLabel[cols.get(i)]).
                            append(rowLabel[rows.get(i)]).
                            append(" ");
                } else {
                    stringMove.append(differences.get(i)).
                            append(colLabel[cols.get(i)]).
                            append(rowLabel[rows.get(i)]).
                            append(" ");
                    MovesHistorySingleton.setFullMovesCounter(MovesHistorySingleton.getFullMovesCounter() + 1);
                }
            }
        }
        return stringMove.toString();
    }
}
