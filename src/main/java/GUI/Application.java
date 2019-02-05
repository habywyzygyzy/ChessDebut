package GUI;

import javax.swing.*;

import static database.DBConnection.openConnection;
import static java.lang.Boolean.TRUE;
import static singletons.ChessBoardSingleton.setIsWhiteMove;

public class Application {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                openConnection();
                setIsWhiteMove(TRUE);
                String[][] data = new String[20][];
                String[] row;

                row = new String[]{"3 Nd8...", "46998", "35.1", "27.5", "37.4"};
                data[0] = row;
                row = new String[]{"3 d5...", "38063", "27.3", "42.8", "35.1"};
                data[1] = row;
                row = new String[]{"3 d8...", "67321", "25.2", "37.4", "42.8"};
                data[2] = row;
                row = new String[]{"3 Bd3...", "12345", "37.4", "27.5", "37.4"};
                data[3] = row;
                row = new String[]{"3 c7...", "45812", "27.5", "25.2", "25.2"};
                data[4] = row;
                row = new String[]{"3 Nd4...", "45619", "25.1", "27.5", "37.4"};
                data[5] = row;
                row = new String[]{"3 Ne5...", "92312", "36.5", "25.1", "25.1"};
                data[6] = row;
                row = new String[]{"3 Na3...", "67349", "35.1", "27.5", "36.5"};
                data[7] = row;
                row = new String[]{"3 a4...", "54213", "42.8", "36.5", "37.4"};
                data[8] = row;
                row = new String[]{"3 b4...", "85123", "27.5", "35.1", "27.5"};
                data[9] = row;
                row = new String[]{"3 Nd8...", "46998", "2018", "35.1", "27.5", "37.4"};
                data[10] = row;
                row = new String[]{"3 d5...", "38063", "2018", "27.3", "42.8", "35.1"};
                data[11] = row;
                row = new String[]{"3 d8...", "67321", "2018", "25.2", "37.4", "42.8"};
                data[12] = row;
                row = new String[]{"3 Bd3...", "12345", "2018", "37.4", "27.5", "37.4"};
                data[13] = row;
                row = new String[]{"3 c7...", "45812", "2018", "27.5", "25.2", "25.2"};
                data[14] = row;
                row = new String[]{"3 Nd4...", "45619", "2018", "25.1", "27.5", "37.4"};
                data[15] = row;
                row = new String[]{"3 Ne5...", "92312", "2018", "36.5", "25.1", "25.1"};
                data[16] = row;
                row = new String[]{"3 Na3...", "67349", "2018", "35.1", "27.5", "36.5"};
                data[17] = row;
                row = new String[]{"3 a4...", "54213", "2018", "42.8", "36.5", "37.4"};
                data[18] = row;
                row = new String[]{"3 b4...", "85123", "2018", "27.5", "35.1", "27.5"};
                data[19] = row;

                new MainFrame(data);

            }
        });
    }
}
