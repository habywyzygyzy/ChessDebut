package GUI;

import tools.Initialize;

import static database.DBConnection.openConnection;
import static database.ExecuteSQL.executeSQL;
import static java.lang.Boolean.TRUE;
import static javax.swing.SwingUtilities.invokeLater;
import static singletons.ChessBoardSingleton.setIsWhiteMove;
import static tools.Initialize.*;

public class Application {
    public static void main(String[] args) {

        invokeLater(new Runnable() {
            public void run() {
                initialize();
                new MainFrame();
            }
        });
    }
}
