package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;

import static singletons.StatisticsSingleton.getStats;

/**
 * Panel that holds the move statisctics
 */
class StatisticsTablePanel extends JPanel {
    /**
     * Creates the StatiscticsTablePanel
     */
    StatisticsTablePanel() {
        final JTable mainTable;
        final String[] columns = {"Move", "# of Games", "% of White Victories", "% of Black Victories", "% of Draws"};
        final String[][] data = new String[0][];
        final DefaultTableModel model = new DefaultTableModel(data, columns);
        mainTable = new JTable(model);
        JTableHeader header = mainTable.getTableHeader();
        mainTable.setAutoCreateRowSorter(true);
        mainTable.setFont(new Font("Arial", Font.PLAIN, 18));
        mainTable.getTableHeader().setFont(new Font("Arial", Font.PLAIN, 18));
        this.setLayout(new BorderLayout());
        this.add(header, BorderLayout.NORTH);
        this.add(mainTable, BorderLayout.CENTER);
        this.setVisible(true);
    }
}