package GUI;

import com.supareno.pgnparser.PGNParser;
import com.supareno.pgnparser.jaxb.Game;
import com.supareno.pgnparser.jaxb.Games;
import com.supareno.pgnparser.jaxb.Hits;
import tools.PrintDebug;
import tools.ReadObject;
import tools.WriteObject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static tools.LoadFolder.loadFolder;
import static tools.PrintDebug.printGame;
import static tools.PrintDebug.printGames;

public class MainFrame extends JFrame {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 219;
    private JPanel mainPanel;
    private JTable mainTable;

    private MainFrame(String[][] data) {
        super("Chess Debut");
        String[] columns = {"Next Move", "# of Games", "Last Played", "% of White Victories", "% of Black Victories", "% of Draws"};
        TableModel model = new DefaultTableModel(data, columns);
        mainTable = new JTable(model);
        JTableHeader header = mainTable.getTableHeader();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        add(header, BorderLayout.NORTH);
        add(mainTable, BorderLayout.CENTER);
    }

    public static void main(String args[]) {

        String[][] data = new String[10][];
        String[] row;

        row = new String[]{"3 Nd8...", "46998", "2018", "35.1", "27.5", "37.4"};
        data[0] = row;
        row = new String[]{"3 d5...", "38063", "2018", "27.3", "42.8", "35.1"};
        data[1] = row;
        row = new String[]{"3 d8...", "67321", "2018", "25.2", "37.4", "42.8"};
        data[2] = row;
        row = new String[]{"3 Bd3...", "12345", "2018", "37.4", "27.5", "37.4"};
        data[3] = row;
        row = new String[]{"3 c7...", "45812", "2018", "27.5", "25.2", "25.2"};
        data[4] = row;
        row = new String[]{"3 Nd4...", "45619", "2018", "25.1", "27.5", "37.4"};
        data[5] = row;
        row = new String[]{"3 Ne5...", "92312", "2018", "36.5", "25.1", "25.1"};
        data[6] = row;
        row = new String[]{"3 Na3...", "67349", "2018", "35.1", "27.5", "36.5"};
        data[7] = row;
        row = new String[]{"3 a4...", "54213", "2018", "42.8", "36.5", "37.4"};
        data[8] = row;
        row = new String[]{"3 b4...", "85123", "2018", "27.5", "35.1", "27.5"};
        data[9] = row;

        /*for (int i = 0; i < 10; i++) {
            data[i] = row;
        }*/

        PrintDebug.TypeOfPrintedMoves type = PrintDebug.TypeOfPrintedMoves.ALL;
        String path = "./example";
        String path2 = "./KingBase2018-pgn";
        String path3 = "./KingBaseLite2018-pgn";
        String serPathGames = "./games.ser";
        String serPathHits = "./hits.ser";
        Games games = null;
        Hits hits = null;
        List<String> listOfMoves = new ArrayList<String>();
        listOfMoves.add("d4 Nf6");
        listOfMoves.add("c4 c5");
        listOfMoves.add("d5 b5");

        new MainFrame(data);

        PGNParser parser = new PGNParser();
        List<Games> gamesList = new ArrayList<Games>();
        long start = System.nanoTime();

        //games = parser.parseFile(loadFolder(path)[0]);
        hits = parser.parseFile(loadFolder(path)[0]).getGame().get(0).getHits();


        long end = System.nanoTime() - start;

        System.out.println("Czas parsowania w ms "  + end/1000000);


        WriteObject writeObj = new WriteObject();
        writeObj.serializeListOfGames(gamesList, serPathGames);
        //writeObj.serializeHits(hits, serPathHits);

        long serialStart = System.nanoTime();
        ReadObject readObj = new ReadObject();
        List<Games> gamesList2 = readObj.deserialzeListOfGames(serPathGames);
        //Hits hits2 = readObj.deserialzeHits(serPathHits);

        long serialEnd = System.nanoTime() - serialStart;

        System.out.println("Czas deserializacji w ms " + serialEnd/1000000);
    }
}
