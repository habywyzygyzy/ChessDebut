package GUI;

import database.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class MainFrame extends JFrame {

    MainFrame() {
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
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 100;
        gbc.weighty = 5;
        setVisible(true);
        PickerPanel pickerPanel = new PickerPanel();
        gbc.anchor = GridBagConstraints.SOUTH;
        add(pickerPanel, gbc);
        StatisticsTablePanel statisticsTablePanel = new StatisticsTablePanel();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 50;
        gbc.weighty = 95;
        gbc.anchor = GridBagConstraints.WEST;
        add(statisticsTablePanel, gbc);
        ChessBoardPanel chessBoardPanel = new ChessBoardPanel();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(chessBoardPanel, gbc);
        setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }
}