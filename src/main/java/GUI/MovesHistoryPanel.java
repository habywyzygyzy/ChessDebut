package GUI;

import singletons.MovesHistorySingleton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Panel that holds moves history
 */
class MovesHistoryPanel extends JPanel {
    /**
     * Createz the panel and sets its visibility and layout
     */
    MovesHistoryPanel() {
        setLayout(new FlowLayout());
        setVisible(true);
    }
}
