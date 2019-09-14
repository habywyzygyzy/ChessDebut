package GUI;

import models.Statistics;
import singletons.FiltersSingleton;
import tools.SortForBlacks;
import tools.SortForWhites;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import static database.SelectData.selectHitsWithTheSameFEN;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static singletons.ChessBoardSingleton.*;
import static singletons.StatisticsSingleton.setStats;
import static tools.ConvertFen.convert;
import static tools.FenHandler.translateBoardToFEN;

class ChessBoardPanel extends JPanel {

    ChessBoardPanel() {
        final JTextField[][] chessBoardSquares = new JTextField[8][8];
        Point[][] currentLocation = new Point[8][8];
        FlowLayout topLayout = new FlowLayout();
        GridLayout chessBoardLayout = new GridLayout(0, 9);
        final ButtonGroup currentMoveRadioGroup = new ButtonGroup();
        final JRadioButton whiteMove = new JRadioButton("White Move", true);
        currentMoveRadioGroup.add(whiteMove);
        whiteMove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setIsWhiteMove(TRUE);
            }
        });
        final JRadioButton blackMove = new JRadioButton("Black Move", false);
        currentMoveRadioGroup.add(blackMove);
        blackMove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setIsWhiteMove(FALSE);
            }
        });
        Button submitButton = new Button("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[][] stringBoard = new String[8][8];
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        stringBoard[j][i] = chessBoardSquares[i][j].getText();
                    }
                }

                String state = translateBoardToFEN(stringBoard);
                getInstance().setState(state);
                printCurrentBoardState();
                ArrayList<Long> longListFen = convert(getInstance().getState());
                ArrayList<Statistics> stats = new ArrayList<Statistics>();
                long start = System.nanoTime();
                stats = selectHitsWithTheSameFEN(longListFen);
                long end = System.nanoTime() - start;
                System.out.println("Wyszukiwanie " + end / 1000000);
                if (getIsWhiteMove())
                    Collections.sort(stats, new SortForWhites());
                else
                    Collections.sort(stats, new SortForBlacks());
                Collections.reverse(stats);
                setStats(stats);
                currentMoveRadioGroup.clearSelection();
                setIsWhiteMove(!getIsWhiteMove());
                if (getIsWhiteMove())
                    whiteMove.setSelected(true);
                else
                    blackMove.setSelected(true);
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
        filtersPanelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FiltersSingleton.setMinELO(0);
                FiltersSingleton.setMinELO(0);
                FiltersSingleton.setName("");
                FiltersSingleton.setOpening("");
                FiltersSingleton.setYear(0);
            }
        });
        JPanel topPanel = new JPanel();
        topPanel.setLayout(topLayout);
        topPanel.add(whiteMove);
        topPanel.add(blackMove);
        topPanel.add(whiteCastling);
        topPanel.add(blackCastling);
        topPanel.add(submitButton);
        topPanel.add(filtersPanelButton);
        topPanel.add(filtersResetButton);
        JPanel chessBoard = new JPanel();
        chessBoard.setLayout(chessBoardLayout);
        prepareChessBoardSquares(chessBoardSquares, currentLocation);
        addColumnLabel(chessBoard);
        addSquaresToBoard(chessBoard, chessBoardSquares);

        this.setLayout(new BorderLayout());
        this.add(chessBoard, BorderLayout.CENTER);
        this.add(topPanel, BorderLayout.NORTH);
        this.setVisible(true);
    }

    private void printCurrentBoardState() {
        System.out.println(getInstance().getState());
    }

    private static void addSquaresToBoard(JPanel chessBoardPanel, JTextField[][] chessBoardSquares) {
        int k = 8;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (j == 0)
                    chessBoardPanel.add(new JLabel(String.valueOf(k), SwingConstants.CENTER));
                chessBoardPanel.add(chessBoardSquares[j][i]);
            }
            k--;
        }
    }

    private static void addColumnLabel(JPanel chessBoardPanel) {
        chessBoardPanel.add(new JLabel(""));
        for (int i = 0; i < 8; i++) {
            chessBoardPanel.add(new JLabel("ABCDEFGH".substring(i, i + 1), SwingConstants.CENTER));
        }
    }

    private static void prepareChessBoardSquares(JTextField[][] chessBoardSquares, Point[][] currentLocation) {
        Font font = new Font("Arial", Font.BOLD, 28);
        Insets margin = new Insets(0, 0, 0, 0);
        for (int i = 0; i < chessBoardSquares.length; i++) {
            for (int j = 0; j < chessBoardSquares[i].length; j++) {
                ImageIcon image = new ImageIcon();
                JTextField field = new JTextField();
                field.setMargin(margin);

                field.setHorizontalAlignment(JTextField.CENTER);
                field.setFont(font);
                field.setForeground(Color.lightGray);
                switch (i) {
                    case 0: {
                        switch (j) {
                            case 0:
                            case 7:
                                field.setText("r");
                                //image = new ImageIcon("simple//BR.gif");
                                break;
                            case 1:
                            case 6:
                                field.setText("n");
                                //image = new ImageIcon("simple//BN.gif");
                                break;
                            case 2:
                            case 5:
                                field.setText("b");
                                //image = new ImageIcon("simple//BB.gif");
                                break;
                            case 3:
                                field.setText("q");
                                //image = new ImageIcon("simple//BQ.gif");
                                break;
                            case 4:
                                field.setText("k");
                                //image = new ImageIcon("simple//BK.gif");
                                break;
                        }

                        break;
                    }
                    case 1:
                        field.setText("p");
                        //image = new ImageIcon("simple//BP.gif");
                        break;
                    case 6:
                        field.setText("P");
                        //image = new ImageIcon("simple//WP.gif");
                        break;
                    case 7: {
                        switch (j) {
                            case 0:
                            case 7:
                                field.setText("R");
                                //image = new ImageIcon("simple//WR.gif");
                                break;
                            case 1:
                            case 6:
                                field.setText("N");
                                //image = new ImageIcon("simple//WN.gif");
                                break;
                            case 2:
                            case 5:
                                field.setText("B");
                                //image = new ImageIcon("simple//WB.gif");
                                break;
                            case 3:
                                field.setText("Q");
                                //image = new ImageIcon("simple//WQ.gif");
                                break;
                            case 4:
                                field.setText("K");
                                //image = new ImageIcon("simple//WK.gif");
                                break;
                        }
                        break;
                    }
                }
                if ((j % 2 == 1 && i % 2 == 1) || (j % 2 == 0 && i % 2 == 0)) {
                    field.setBackground(Color.WHITE);
                } else {
                    field.setBackground(Color.BLACK);
                }
                //field.setIcon(image);
                //System.out.println(field.getIcon());
                //field.setOpaque(true);
                chessBoardSquares[j][i] = field;
                //currentLocation[j][i] = chessBoardSquares[j][i].getLocation();
            }
        }
    }
    /*@Override
    public void mouseDragged(MouseEvent e) {

        Point p = e.getPoint();
        currentLocation.x = (int) p.getX();
        currentLocation.y = (int) p.getY() - 250; // Height/2

        .setLocation(currentLocation);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }*/
}