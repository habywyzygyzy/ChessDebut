package GUI;

import com.supareno.pgnparser.PGNParser;
import com.supareno.pgnparser.jaxb.Games;
import singletons.ParseFolderPathSingleton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static tools.LoadFolder.*;
import static tools.LoadFolder.loadFolder;

public class PickerPanel extends JPanel {

    public PickerPanel(int width, int height) {
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
                    File selectedFolder = fileChooser.getSelectedFile();
                    dirLabel.setText(selectedFolder.getAbsolutePath());
                    ParseFolderPathSingleton.getInstance().setFiles(loadFolder(selectedFolder.getAbsolutePath()));
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
            }
        });

        JButton chooseDatabase = new JButton("Choose Database");
        chooseDatabase.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(dirPickerButton);
        this.add(Box.createRigidArea(new Dimension(5, 10)));
        this.add(dirLabel);
        this.add(Box.createRigidArea(new Dimension(5, 10)));
        this.add(parsePGNFromFolder);
        this.add(Box.createRigidArea(new Dimension(5, 10)));
        this.add(chooseDatabase);
        this.add(Box.createRigidArea(new Dimension(5, 10)));
        this.add(testLabel);
        this.setBackground(Color.WHITE);
        this.setVisible(true);
    }
}
