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

public class StatisticsTablePanel extends JPanel {
    public StatisticsTablePanel() {
        final JTable mainTable;
        final String[] columns = {"Next Move", "# of Games", "% of White Victories", "% of Black Victories", "% of Draws"};
        final String[][] data = new String[0][];
        final DefaultTableModel model = new DefaultTableModel(data, columns);

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            String[] row;

            public void actionPerformed(ActionEvent e) {
                String hit;
                Double percentDraws, percentWhite, percentBlack;
                Integer nrOfGames;
                Double toBeTruncated = new Double("3.5789055");

                Double truncatedDouble = BigDecimal.valueOf(toBeTruncated)
                        .setScale(2, RoundingMode.HALF_UP)
                        .doubleValue();

                for (int i = 0; i < getStats().size() && i < 20; i++) {
                    hit = getStats().get(i).getHit();
                    nrOfGames = getStats().get(i).getWhiteWins() + getStats().get(i).getBlackWins() + getStats().get(i).getDraws();
                    if (getStats().get(i).getDraws() != 0)
                        percentDraws = (double) getStats().get(i).getDraws() / nrOfGames * 100.00;
                    else
                        percentDraws = 0.00;
                    percentDraws = BigDecimal.valueOf(percentDraws)
                            .setScale(2, RoundingMode.HALF_UP)
                            .doubleValue();
                    if (getStats().get(i).getWhiteWins() != 0)
                        percentWhite = (double) getStats().get(i).getWhiteWins() / nrOfGames * 100.00;
                    else
                        percentWhite = 0.00;
                    percentWhite = BigDecimal.valueOf(percentWhite)
                            .setScale(2, RoundingMode.HALF_UP)
                            .doubleValue();
                    if (getStats().get(i).getBlackWins() != 0)
                        percentBlack = (double) getStats().get(i).getBlackWins() / nrOfGames * 100.00;
                    else
                        percentBlack = 0.00;
                    percentBlack = BigDecimal.valueOf(percentBlack)
                            .setScale(2, RoundingMode.HALF_UP)
                            .doubleValue();
                    row = new String[]{hit, nrOfGames.toString(), percentWhite.toString(), percentBlack.toString(), percentDraws.toString()};
                    model.addRow(row);
                }
            }
        });
        mainTable = new JTable(model);
        JTableHeader header = mainTable.getTableHeader();
        this.setLayout(new BorderLayout());
        this.add(header, BorderLayout.NORTH);
        this.add(mainTable, BorderLayout.CENTER);
        this.add(searchButton, BorderLayout.SOUTH);
        this.setVisible(true);
    }
}