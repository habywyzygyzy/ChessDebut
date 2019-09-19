package GUI;

import singletons.MovesHistorySingleton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

class MovesHistoryFrame extends JFrame {
    MovesHistoryFrame() {
        super("Moves history");
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setVisible(true);
        Dimension buttonSize = new Dimension(200, 50);
        setPreferredSize(new Dimension(500, 300));
        final JLabel history = new JLabel(MovesHistorySingleton.getMoves().toString());
        mainPanel.setBorder(new EmptyBorder(10, 10, 0, 0));
        mainPanel.add(history, BorderLayout.NORTH);
        JButton closeButton = new JButton("Close");
        closeButton.setPreferredSize(buttonSize);
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        JButton refreshButton = new JButton("Refresh");
        refreshButton.setPreferredSize(buttonSize);
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                history.setText(MovesHistorySingleton.getMoves().toString());
            }
        });
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.add(closeButton);
        bottomPanel.add(refreshButton);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        add(mainPanel);
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
    }
}
