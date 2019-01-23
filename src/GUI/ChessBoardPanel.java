package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChessBoardPanel extends JPanel{
    public ChessBoardPanel(int width, int height) {
        final JTextField[][] chessBoardSquares = new JTextField[8][8];
        final String[][] chessBoardState = new String[8][8];
        GridLayout chessBoardLayout = new GridLayout(0, 9);
        Button submitButton = new Button("Submit");
        JPanel chessBoard = new JPanel();
        chessBoard.setLayout(chessBoardLayout);
        prepareChessBoardSquares(chessBoardSquares);
        addColumnLabel(chessBoard);
        addSquaresToBoard(chessBoard, chessBoardSquares);
        submitChanges(chessBoardSquares, chessBoardState, submitButton);
        this.setLayout(new BorderLayout());
        this.add(chessBoard, BorderLayout.CENTER);
        this.add(submitButton, BorderLayout.NORTH);
        this.setPreferredSize(new Dimension(width, height));
        this.setVisible(true);
    }

    private static void submitChanges(final JTextField[][] chessBoardSquares, final String[][] chessBoardState, Button submitButton) {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        chessBoardState[i][j] = chessBoardSquares[i][j].getText();
                    }
                }
                printCurrentBoardState();
            }

            private void printCurrentBoardState() {
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (chessBoardState[j][i].length() < 2)
                            chessBoardState[j][i] += " ";
                        System.out.print(chessBoardState[j][i] + " ");
                    }
                    System.out.print("\n");
                }
            }
        });
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
                                field.setText("bR");
                                break;
                            case 1:
                            case 6:
                                field.setText("bN");
                                break;
                            case 2:
                            case 5:
                                field.setText("bB");
                                break;
                            case 3:
                                field.setText("bQ");
                                break;
                            case 4:
                                field.setText("bK");
                                break;
                        }
                        break;
                    }
                    case 1:
                        field.setText("b");
                        break;
                    case 6:
                        field.setText("w");
                        break;
                    case 7: {
                        switch (j) {
                            case 0:
                            case 7:
                                field.setText("wR");
                                break;
                            case 1:
                            case 6:
                                field.setText("wN");
                                break;
                            case 2:
                            case 5:
                                field.setText("wB");
                                break;
                            case 3:
                                field.setText("wQ");
                                break;
                            case 4:
                                field.setText("wK");
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
