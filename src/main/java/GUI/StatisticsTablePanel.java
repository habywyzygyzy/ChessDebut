package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import java.awt.*;

public class StatisticsTablePanel extends JPanel {
    public StatisticsTablePanel(int width, int height, String[][] data) {
        JTable mainTable;
        final String[] columns = {"Next Move", "# of Games", "% of White Victories", "% of Black Victories", "% of Draws"};
        TableModel model = new DefaultTableModel(data, columns);
        mainTable = new JTable(model);
        JTableHeader header = mainTable.getTableHeader();
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(width, height));
        this.add(header, BorderLayout.NORTH);
        this.add(mainTable, BorderLayout.CENTER);
        this.setVisible(true);
    }
}
