package GUI;

import database.DBConnection;
import models.Statistics;
import singletons.ChessBoardSingleton;
import singletons.FiltersSingleton;
import singletons.MovesHistorySingleton;
import singletons.StatisticsSingleton;
import tools.ConvertFen;
import tools.SaveMoveForGameHistory;
import tools.SortForBlacks;
import tools.SortForWhites;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;

import static GUI.ChessBoardPanel.*;
import static database.SelectData.selectHitsWithTheSameFEN;
import static java.lang.Boolean.FALSE;
import static singletons.ChessBoardSingleton.*;
import static singletons.StatisticsSingleton.getStats;
import static tools.CaptureCheck.wasCaptured;
import static tools.FenHandler.translateBoardToFEN;

/**
 * Main frame - windows of application
 */
class MainFrame extends JFrame {

    /**
     * Creates the MainFrame
     */
    MainFrame() {
        super("Chess Debut");
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;
        menuBar = new JMenuBar();
        menu = new JMenu("Menu");
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
        setVisible(true);

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
        final JPanel chessBoard = new JPanel();
        chessBoard.setMinimumSize(new Dimension(width *50/100, height * 9 / 10));
        chessBoard.setPreferredSize(new Dimension(width *50/100, height * 9 / 10));
        final JLabel movesLabel = new JLabel(MovesHistorySingleton.getMoves().toString());
        movesLabel.setVerticalAlignment(SwingConstants.TOP);
        movesLabel.setHorizontalAlignment(SwingConstants.LEFT);
        setConstraintsForMovesHistoryPanel(gbc);
        final MovesHistoryPanel movesHistoryPanel = new MovesHistoryPanel();
        movesHistoryPanel.add(movesLabel);
        add(movesHistoryPanel, gbc);

        final StatisticsTablePanel statisticsTablePanel = new StatisticsTablePanel();
        statisticsTablePanel.setMinimumSize(new Dimension(width*50/100, height * 9 / 10));
        statisticsTablePanel.setPreferredSize(new Dimension(width*50/100, height * 9 / 10));
        final String[] columns = {"Move", "# of Games", "% of White Victories", "% of Black Victories", "% of Draws"};
        final String[][] data = new String[0][];
        final DefaultTableModel model = new DefaultTableModel(data, columns);
        final JTable[] mainTable = new JTable[1];
        final DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        final NumberFormat nf= NumberFormat.getInstance();
        nf.setMinimumFractionDigits(2);
        nf.setRoundingMode(RoundingMode.HALF_UP);
        final DecimalFormat df = new DecimalFormat("#.00");
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        setConstraintsForStatisticsPanel(gbc);
        add(statisticsTablePanel, gbc);

        ChessBoardPanel chessBoardPanel = new ChessBoardPanel();
        final JTextField[][] chessBoardSquares = new JTextField[8][8];
        GridLayout chessBoardLayout = new GridLayout(0, 9);
        FlowLayout topLayout = new FlowLayout();
        Button submitButton = new Button("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                long start, end;
                String[][] stringBoard = new String[8][8];
                for (int i = 0; i < 8; i++)
                    for (int j = 0; j < 8; j++)
                        stringBoard[j][i] = chessBoardSquares[i][j].getText();
                ArrayList<String> differences = new ArrayList<>();
                ArrayList<Integer> rowIndex = new ArrayList<>();
                ArrayList<Integer> columnIndex = new ArrayList<>();
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (!getInstance().getState()[i][j].equals(stringBoard[i][j])) {
                            differences.add(stringBoard[i][j]);
                            rowIndex.add(i);
                            columnIndex.add(j);
                        }
                    }
                }
                boolean capture;
                capture = wasCaptured(stringBoard, getInstance().getState());
                getInstance().setState(stringBoard);
                if (differences.size() != 0)
                    MovesHistorySingleton.setMoves(MovesHistorySingleton.getMoves().
                            append(SaveMoveForGameHistory.saveMoveToString(differences, rowIndex, columnIndex, capture)));
                String stateFEN = translateBoardToFEN(getInstance().getState());
                ConvertFen converter = new ConvertFen();
                System.out.println(stateFEN);
                long[] longArrayFEN = converter.convert(stateFEN);
                System.out.println(longArrayFEN[0] + " " + longArrayFEN[1] + " "  + longArrayFEN[2] + " "  + longArrayFEN[3]);
                ArrayList<Statistics> stats;
                start = System.nanoTime();
                stats = selectHitsWithTheSameFEN(longArrayFEN);
                end = System.nanoTime() - start;
                System.out.println("Wyszukiwanie " + end / 1000000);
                if (getIsWhiteMove())
                    Collections.sort(stats, new SortForWhites());
                else
                    Collections.sort(stats, new SortForBlacks());
                Collections.reverse(stats);
                StatisticsSingleton.setStats(stats);
                setIsWhiteMove(!getIsWhiteMove());
                movesLabel.setText(MovesHistorySingleton.getMoves().toString());
                movesHistoryPanel.remove(movesLabel);
                movesHistoryPanel.add(movesLabel);
                String hit;
                double percentDraws, percentWhite, percentBlack;
                int nrOfGames;
                String[] row;
                model.setRowCount(0);
                for (int i = 0; i < getStats().size(); i++) {
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
                    if (ChessBoardSingleton.getIsWhiteMove())
                        row = new String[]{"Black move: " + hit, Integer.toString(nrOfGames), String.valueOf(nf.format(percentWhite)), String.valueOf(nf.format(percentBlack)), String.valueOf(nf.format(percentDraws))};
                    else
                        row = new String[]{"White move: " + hit, Integer.toString(nrOfGames), String.valueOf(nf.format(percentWhite)), String.valueOf(nf.format(percentBlack)), String.valueOf(nf.format(percentDraws))};
                    model.addRow(row);
                    mainTable[0] = new JTable(model);
                    mainTable[0].setFont(new Font("Arial", Font.PLAIN, 18));
                    mainTable[0].getTableHeader().setFont(new Font("Arial", Font.PLAIN, 18));
                    mainTable[0].getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
                    mainTable[0].getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
                    mainTable[0].getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
                    mainTable[0].getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
                    mainTable[0].setAutoResizeMode(1);
                    mainTable[0].setRowHeight(30);
                    statisticsTablePanel.remove(1);
                    statisticsTablePanel.add(mainTable[0]);
                    chessBoard.removeAll();
                    prepareChessBoardSquares(chessBoardSquares);
                    addSquaresToBoard(chessBoard, chessBoardSquares);
                    addColumnLabel(chessBoard);
                }
            }
        });

        setBlackCastlingDone(FALSE);
        setWhiteCastlingDone(FALSE);
        JCheckBox whiteCastling = new JCheckBox("White castling done", false);
        whiteCastling.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setWhiteCastlingDone(!getWhiteCastlingDone());
            }
        });
        JCheckBox blackCastling = new JCheckBox("Black castling done", false);
        blackCastling.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBlackCastlingDone(!getBlackCastlingDone());
            }
        });
        JButton filtersPanelButton = new JButton("Add filters");
        filtersPanelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FiltersFrame();
            }
        });
        JButton filtersResetButton = new JButton("Reset filters");
        filtersResetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FiltersSingleton.setMinELO(0);
                FiltersSingleton.setMaxELO(0);
                FiltersSingleton.setName("");
                FiltersSingleton.setOpening("");
                FiltersSingleton.setYear(0);
            }
        });
        JPanel topPanel = new JPanel();
        topPanel.setLayout(topLayout);
        topPanel.add(whiteCastling);
        topPanel.add(blackCastling);
        topPanel.add(submitButton);
        topPanel.add(filtersPanelButton);
        topPanel.add(filtersResetButton);
        chessBoard.setLayout(chessBoardLayout);
        prepareChessBoardSquares(chessBoardSquares);
        addSquaresToBoard(chessBoard, chessBoardSquares);
        addColumnLabel(chessBoard);
        chessBoardPanel.setLayout(new BorderLayout());
        chessBoardPanel.add(chessBoard, BorderLayout.CENTER);
        chessBoardPanel.add(topPanel, BorderLayout.NORTH);
        setConstraintsForChessBoardPanel(gbc);
        add(chessBoardPanel, gbc);
        pack();
        setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }

    /**
     * Sets the constraints for ChessBoardPanel
     *
     * @param gbc GridBagConstraints for GridBagLayout
     */
    private void setConstraintsForChessBoardPanel(GridBagConstraints gbc) {
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 50;
        gbc.weighty = 95;
        gbc.anchor = GridBagConstraints.WEST;
    }

    /**
     * Sets the constraints for MovesHistoryPanel
     *
     * @param gbc GridBagConstraints for GridBagLayout
     */
    private void setConstraintsForMovesHistoryPanel(GridBagConstraints gbc) {
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 100;
        gbc.weighty = 5;
        gbc.anchor = GridBagConstraints.SOUTH;
    }

    /**
     * Sets the constraints for StatiscticsPanel
     *
     * @param gbc GridBagConstraints for GridBagLayout
     */
    private void setConstraintsForStatisticsPanel(GridBagConstraints gbc) {
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 50;
        gbc.weighty = 95;
        gbc.anchor = GridBagConstraints.LINE_END;
    }
}