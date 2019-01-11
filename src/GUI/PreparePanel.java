package GUI;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.io.File;

public class PreparePanel {
    public static void preparePickerPanel(JPanel pickerPanel, int width, int height) {
        pickerPanel.setLayout(new BorderLayout());
        pickerPanel.setSize(width, height);
        pickerPanel.setVisible(true);
        JFileChooser chooser = new JFileChooser();
        chooser.addChoosableFileFilter(new FileFilter() {
            public String getDescription() {
                return "PGN Documents (*.pgn)";
            }
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    return f.getName().toLowerCase().endsWith(".pgn");
                }
            }
        });
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.showSaveDialog(null);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
            System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
        } else {
            System.out.println("No Selection ");
        }
        pickerPanel.add(chooser, BorderLayout.CENTER);
    }
}
