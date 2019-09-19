package tools;

public class CaptureCheck {
    public static boolean wasCaptured(String[][] board, String[][] board2){
        int counter = 0;
        int counter2 = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j].isEmpty())
                    counter++;
                if (board2[i][j].isEmpty())
                    counter2++;
            }
        }
        if (counter == counter2)
            return false;
        else
            return true;
    }
}
