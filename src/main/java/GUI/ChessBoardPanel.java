package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static singletons.ChessBoardSingleton.*;
import static tools.FenHandler.translateBoardToFEN;

public class ChessBoardPanel extends JPanel {

    public ChessBoardPanel() {
        final JTextField[][] chessBoardSquares = new JTextField[8][8];
        FlowLayout topLayout = new FlowLayout();
        GridLayout chessBoardLayout = new GridLayout(0, 9);
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
                if (getWhiteCastlingDone())
                    System.out.println("White castling not possible");
                if (getBlackCastlingDone())
                    System.out.println("Black castling not possible");
            }
        });

        ButtonGroup currentMoveRadioGroup = new ButtonGroup();
        JRadioButton whiteMove = new JRadioButton("White Move", true);
        currentMoveRadioGroup.add(whiteMove);
        whiteMove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setIsWhiteMove(TRUE);
            }
        });
        JRadioButton blackMove = new JRadioButton("Black Move", false);
        currentMoveRadioGroup.add(blackMove);
        blackMove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setIsWhiteMove(FALSE);
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

        JPanel topPanel = new JPanel();
        topPanel.setLayout(topLayout);
        topPanel.add(whiteMove);
        topPanel.add(blackMove);
        topPanel.add(whiteCastling);
        topPanel.add(blackCastling);
        topPanel.add(submitButton);

        JPanel chessBoard = new JPanel();
        chessBoard.setLayout(chessBoardLayout);
        prepareChessBoardSquares(chessBoardSquares);
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

    private static void prepareChessBoardSquares(JTextField[][] chessBoardSquares) {
        Font font = new Font("Arial", Font.BOLD, 28);
        Insets margin = new Insets(0, 0, 0, 0);
        for (int i = 0; i < chessBoardSquares.length; i++) {
            for (int j = 0; j < chessBoardSquares[i].length; j++) {
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
                                break;
                            case 1:
                            case 6:
                                field.setText("n");
                                break;
                            case 2:
                            case 5:
                                field.setText("b");
                                break;
                            case 3:
                                field.setText("q");
                                break;
                            case 4:
                                field.setText("k");
                                break;
                        }

                        break;
                    }
                    case 1:
                        field.setText("p");
                        break;
                    case 6:
                        field.setText("P");
                        break;
                    case 7: {
                        switch (j) {
                            case 0:
                            case 7:
                                field.setText("R");
                                break;
                            case 1:
                            case 6:
                                field.setText("N");
                                break;
                            case 2:
                            case 5:
                                field.setText("B");
                                break;
                            case 3:
                                field.setText("Q");
                                break;
                            case 4:
                                field.setText("K");
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
                chessBoardSquares[j][i] = field;
            }
        }
    }
}