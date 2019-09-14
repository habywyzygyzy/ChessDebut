package GUI;

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
        Dimension labelSize = new Dimension(200, 50);
        Dimension textFieldNumberSize = new Dimension(100, 50);
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(400, 600));
        //JPanel contentPanel = new JPanel();
        Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        //contentPanel.setBorder(padding);
        //contentPanel.setLayout(new GridLayout(6, 2));

        JLabel dateLabel = new JLabel("From year");
        dateLabel.setPreferredSize(labelSize);
        add(dateLabel, 0);
        final JTextField dateText = new JTextField("2000");
        dateText.setMargin(new Insets(10, 10, 10, 10));
        dateText.setPreferredSize(textFieldNumberSize);
        add(dateText, 1);

        JLabel minELOLabel = new JLabel("Minimum ELO");
        minELOLabel.setPreferredSize(labelSize);
        add(minELOLabel, 2);
        final JTextField minELOText = new JTextField("0");
        minELOText.setMargin(new Insets(10, 10, 10, 10));
        minELOText.setPreferredSize(textFieldNumberSize);
        add(minELOText, 3);

        JLabel maxELOLabel = new JLabel("Maximum ELO");
        maxELOLabel.setPreferredSize(labelSize);
        add(maxELOLabel, 4);
        final JTextField maxELOText = new JTextField("0");
        maxELOText.setMargin(new Insets(10, 10, 10, 10));
        maxELOText.setPreferredSize(textFieldNumberSize);
        add(maxELOText, 5);

        JLabel openingLabel = new JLabel("Opening");
        openingLabel.setPreferredSize(labelSize);
        add(openingLabel, 6);
        final JTextField openingText = new JTextField("");
        openingText.setMargin(new Insets(10, 10, 10, 10));
        openingText.setPreferredSize(labelSize);
        add(openingText, 7);

        JLabel playerNameLabel = new JLabel("Player name");
        playerNameLabel.setPreferredSize(labelSize);
        add(playerNameLabel, 8);
        final JTextField playerNameText = new JTextField("");
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
                setName(playerNameText.getText());
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

        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
        //setContentPane(contentPanel);
    }
}
