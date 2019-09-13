package GUI;

import singletons.FiltersSingleton;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import static singletons.FiltersSingleton.*;

class FiltersFrame extends JFrame {
    FiltersFrame() {
        super("Filters");
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(400, 600));
        //JPanel contentPanel = new JPanel();
        Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        //contentPanel.setBorder(padding);
        //contentPanel.setLayout(new GridLayout(6, 2));

        JLabel dateLabel = new JLabel("From year");
        dateLabel.setPreferredSize(new Dimension(200, 50));
        add(dateLabel, 0);
        final JTextField dateText = new JTextField("");
        dateText.setMargin(new Insets(10,10,10,10));
        dateText.setPreferredSize(new Dimension(50, 50));
        add(dateText, 1);

        JLabel minELOLabel = new JLabel("Minimum ELO");
        minELOLabel.setPreferredSize(new Dimension(200, 50));
        add(minELOLabel, 2);
        final JTextField minELOText = new JTextField("");
        minELOText.setMargin(new Insets(10,10,10,10));
        minELOText.setPreferredSize(new Dimension(50, 50));
        add(minELOText, 3);

        JLabel maxELOLabel = new JLabel("Maximum ELO");
        maxELOLabel.setPreferredSize(new Dimension(200, 50));
        add(maxELOLabel, 4);
        final JTextField maxELOText = new JTextField("");
        maxELOText.setMargin(new Insets(10,10,10,10));
        maxELOText.setPreferredSize(new Dimension(50, 50));
        add(maxELOText, 5);

        JLabel openingLabel = new JLabel("Opening");
        openingLabel.setPreferredSize(new Dimension(200, 50));
        add(openingLabel, 6);
        final JTextField openingText = new JTextField("");
        openingText.setMargin(new Insets(10,10,10,10));
        openingText.setPreferredSize(new Dimension(200, 50));
        add(openingText, 7);

        JLabel playerNameLabel = new JLabel("Player name");
        playerNameLabel.setPreferredSize(new Dimension(200, 50));
        add(playerNameLabel, 8);
        final JTextField playerNameText = new JTextField("");
        playerNameText.setMargin(new Insets(10,10,10,10));
        playerNameText.setPreferredSize(new Dimension(200, 50));
        add(playerNameText, 9);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setPreferredSize(new Dimension(200, 50));
        add(confirmButton, 10);

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setYear(Integer.parseInt(dateText.getText()));
                setMaxELO(Integer.parseInt(maxELOText.getText()));
                setMinELO(Integer.parseInt(minELOText.getText()));
                setOpening(openingText.getText());
                setName(playerNameText.getText());
            }
        });

        JButton closeButton = new JButton("Close");
        closeButton.setPreferredSize(new Dimension(200, 50));
        add(closeButton, 11);

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
        //setContentPane(contentPanel);
    }
}
