package GUI;

import tools.Initialize;

import static database.DBConnection.openConnection;
import static database.ExecuteSQL.executeSQL;
import static java.lang.Boolean.TRUE;
import static javax.swing.SwingUtilities.invokeLater;
import static singletons.ChessBoardSingleton.setIsWhiteMove;
import static tools.Initialize.*;

/**
 * Main class of application
 */
public class Application {
    /**
     * Runs the Application, initializes data and creates the MainFrame - GUI
     * @param args
     */
    public static void main(String[] args) {

        invokeLater(new Runnable() {
            public void run() {
                initialize();
                new MainFrame();
            }
        });
    }
}
