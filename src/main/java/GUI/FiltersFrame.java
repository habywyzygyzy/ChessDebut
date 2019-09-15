package GUI;

import singletons.FiltersSingleton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import static singletons.FiltersSingleton.*;

class FiltersFrame extends JFrame {
    FiltersFrame() {
        super("Filters");
        String year, minELO, maxELO, opening, name;
        year = String.valueOf(getYear());
        minELO = String.valueOf(getMinELO());
        maxELO = String.valueOf(getMaxELO());
        opening = getOpening();
        name = FiltersSingleton.getName();
        Dimension labelSize = new Dimension(200, 50);
        Dimension textFieldNumberSize = new Dimension(100, 50);
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(400, 600));

        JLabel dateLabel = new JLabel("From year");
        dateLabel.setPreferredSize(labelSize);
        add(dateLabel, 0);
        final JTextField dateText = new JTextField(year);
        dateText.setMargin(new Insets(10, 10, 10, 10));
        dateText.setPreferredSize(textFieldNumberSize);
        add(dateText, 1);

        JLabel minELOLabel = new JLabel("Minimum ELO");
        minELOLabel.setPreferredSize(labelSize);
        add(minELOLabel, 2);
        final JTextField minELOText = new JTextField(minELO);
        minELOText.setMargin(new Insets(10, 10, 10, 10));
        minELOText.setPreferredSize(textFieldNumberSize);
        add(minELOText, 3);

        JLabel maxELOLabel = new JLabel("Maximum ELO");
        maxELOLabel.setPreferredSize(labelSize);
        add(maxELOLabel, 4);
        final JTextField maxELOText = new JTextField(maxELO);
        maxELOText.setMargin(new Insets(10, 10, 10, 10));
        maxELOText.setPreferredSize(textFieldNumberSize);
        add(maxELOText, 5);

        JLabel openingLabel = new JLabel("Opening");
        openingLabel.setPreferredSize(labelSize);
        add(openingLabel, 6);
        final JTextField openingText = new JTextField(opening);
        openingText.setMargin(new Insets(10, 10, 10, 10));
        openingText.setPreferredSize(labelSize);
        add(openingText, 7);

        JLabel playerNameLabel = new JLabel("Player name");
        playerNameLabel.setPreferredSize(labelSize);
        add(playerNameLabel, 8);
        final JTextField playerNameText = new JTextField(name);
        playerNameText.setMargin(new Insets(10, 10, 10, 10));
        playerNameText.setPreferredSize(labelSize);
        add(playerNameText, 9);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setPreferredSize(labelSize);
        add(confirmButton, 10);

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setYear(Integer.parseInt(dateText.getText()));
                setMaxELO(Integer.parseInt(maxELOText.getText()));
                setMinELO(Integer.parseInt(minELOText.getText()));
                setOpening(openingText.getText());
                FiltersSingleton.setName(playerNameText.getText());
            }
        });

        JButton closeButton = new JButton("Close");
        closeButton.setPreferredSize(labelSize);
        add(closeButton, 11);

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
    }
}
