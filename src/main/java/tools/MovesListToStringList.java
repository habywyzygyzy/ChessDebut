package tools;

import java.util.ArrayList;

public class MovesListToStringList {
    public static  ArrayList<String> saveMovesToList(StringBuilder movesList){
        ArrayList<String> stringList = new ArrayList<String>();
        String line = movesList.toString();
        String[] arr = line.split(" ");
        ArrayList<String> newLines;
        newLines = new ArrayList<String>();
        for (int i = 0; i < arr.length; i++){
            newLines.add(arr[i]);
            if (!newLines.get(i).contains(".") && !newLines.get(i).equals(" ") && !newLines.get(i).equals("\n"))
                stringList.add(newLines.get(i));
        }
        stringList.remove(stringList.size()-1);
        return stringList;
    }
}
