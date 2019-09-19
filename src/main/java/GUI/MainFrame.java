package GUI;

import database.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

class MainFrame extends JFrame {

    MainFrame() {
        super("Chess Debut");
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;
        menuBar = new JMenuBar();
        menu = new JMenu("A Menu");
        menuBar.add(menu);
        menuItem = new JMenuItem("Parse PGN Folder");
        menu.add(menuItem);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PickerFrame();
            }
        });
        setJMenuBar(menuBar);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                try {
                    DBConnection.closeConnection();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
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
        //PickerPanel pickerPanel = new PickerPanel();
        //gbc.anchor = GridBagConstraints.SOUTH;
        //add(pickerPanel, gbc);
        StatisticsTablePanel statisticsTablePanel = new StatisticsTablePanel();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 50;
        gbc.weighty = 95;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(statisticsTablePanel, gbc);
        ChessBoardPanel chessBoardPanel = new ChessBoardPanel();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 50;
        gbc.weighty = 95;
        gbc.anchor = GridBagConstraints.WEST;
        add(chessBoardPanel, gbc);
        pack();
        setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }
}