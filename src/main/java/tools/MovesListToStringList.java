package tools;

import java.util.ArrayList;

/**
 * Save all moves list from PGN game to list of strings (each String is single move)
 */
public class MovesListToStringList {
    /**
     * @param movesList String containg all moves from PGN game
     * @return List of all moves saved in array
     */
    public static ArrayList<String> saveMovesToList(StringBuilder movesList) {
        ArrayList<String> stringList = new ArrayList<String>();
        String line = movesList.toString();
        if (line.charAt(2) != ' ')
            line = line.replaceAll("\\.", ". ");
        String[] arr = line.split(" ");
        ArrayList<String> newLines;
        newLines = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            newLines.add(arr[i]);
            if (!newLines.get(i).contains(".") && !newLines.get(i).equals(" ") && !newLines.get(i).equals("\n"))
                stringList.add(newLines.get(i));
        }
        stringList.remove(stringList.size() - 1);
        return stringList;
    }
}
