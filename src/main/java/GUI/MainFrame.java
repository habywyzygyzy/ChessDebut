package GUI;

import database.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 1200;

    public MainFrame(String[][] data) {
        super("Chess Debut");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                DBConnection.closeConnection();
                dispose();
                System.exit(0);
            }
        });
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setVisible(true);
        PickerPanel pickerPanel = new PickerPanel(300, 100);
        StatisticsTablePanel statisticsTablePanel = new StatisticsTablePanel(1000, HEIGHT, data);
        ChessBoardPanel chessBoardPanel = new ChessBoardPanel(950, HEIGHT);
        getContentPane().add(pickerPanel, BorderLayout.SOUTH);
        getContentPane().add(statisticsTablePanel, BorderLayout.WEST);
        getContentPane().add(chessBoardPanel, BorderLayout.EAST);
        setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }
}
