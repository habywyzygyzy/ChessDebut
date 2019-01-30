package GUI;

import com.supareno.pgnparser.PGNParser;
import com.supareno.pgnparser.jaxb.Games;
import database.DBExecutor;
import singletons.ParseFolderPathSingleton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static tools.LoadFolder.loadFolder;

public class PickerPanel extends JPanel {

    public PickerPanel(int width, int height) {
        final File[] selectedFolder = {new File("C:\\Users\\Kamil\\Desktop\\Politechnika\\INZ\\ChessDebut\\example")};
        ParseFolderPathSingleton.getInstance().setFiles(loadFolder(selectedFolder[0].getAbsolutePath()));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(width, height));
        final JLabel dirLabel = new JLabel("Directory", JLabel.CENTER);
        dirLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        final JLabel testLabel = new JLabel("Test", JLabel.CENTER);
        dirLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton dirPickerButton = new JButton("Select Folder");
        dirPickerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        dirPickerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                JFileChooser fileChooser = new JFileChooser();
                File[] files = new File[0];
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                fileChooser.setAcceptAllFileFilterUsed(false);
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    selectedFolder[0] = fileChooser.getSelectedFile();
                    dirLabel.setText(selectedFolder[0].getAbsolutePath());
                    ParseFolderPathSingleton.getInstance().setFiles(loadFolder(selectedFolder[0].getAbsolutePath()));
                }
            }
        });

        JButton parsePGNFromFolder = new JButton("Parse");
        parsePGNFromFolder.setAlignmentX(Component.CENTER_ALIGNMENT);
        parsePGNFromFolder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                PGNParser parser = new PGNParser();
                long start = System.nanoTime();
                Games games = new Games();
                for (int i = 0; i < ParseFolderPathSingleton.getInstance().getFiles().length; i++)
                    games = parser.parseFile(ParseFolderPathSingleton.getInstance().getFiles()[i]);
                long end = System.nanoTime() - start;
                System.out.println("Czas parsowania w ms " + end / 1000000);
                DBExecutor db = new DBExecutor();
                db.Test();
            }
        });

        JButton chooseDatabase = new JButton("Choose DBExecutor");
        chooseDatabase.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(dirPickerButton);
        this.add(Box.createRigidArea(new Dimension(5, 10)));
        this.add(dirLabel);
        this.add(Box.createRigidArea(new Dimension(5, 10)));
        this.add(parsePGNFromFolder);
        this.add(Box.createRigidArea(new Dimension(5, 10)));
        //this.add(chooseDatabase);
        this.add(Box.createRigidArea(new Dimension(5, 10)));
        //this.add(testLabel);
        this.setBackground(Color.WHITE);
        this.setVisible(true);
    }
}
