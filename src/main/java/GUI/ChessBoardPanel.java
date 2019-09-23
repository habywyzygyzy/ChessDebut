package GUI;

import singletons.ChessBoardSingleton;

import javax.swing.*;
import java.awt.*;

import static singletons.ChessBoardSingleton.getInstance;

/**
 * Chessboard Panel
 */
class ChessBoardPanel extends JPanel {

    /**
     * Sets the panel visibility
     */
    ChessBoardPanel() {
        this.setVisible(true);
    }

    /**
     * Prinsts current chessboard state in console using String[][]
     */
    private void printCurrentBoardState() {
        for (String[] strings : getInstance().getState()) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    /**
     * @param chessBoardPanel   Panel with chessboard
     * @param chessBoardSquares 2D array of squares inside chessboard
     */
    static void addSquaresToBoard(JPanel chessBoardPanel, JTextField[][] chessBoardSquares) {
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

    /**
     * Adds labels for columns
     *
     * @param chessBoardPanel Chessboard panel
     */
    static void addColumnLabel(JPanel chessBoardPanel) {
        chessBoardPanel.add(new JLabel(""));
        for (int i = 0; i < 8; i++) {
            chessBoardPanel.add(new JLabel("ABCDEFGH".substring(i, i + 1), SwingConstants.CENTER));
        }
    }

    /**
     * Sets color, font, icons for chessboard squares
     *
     * @param chessBoardSquares 2D array of squares insde the chessboard
     */
    static void prepareChessBoardSquares(JTextField[][] chessBoardSquares) {
        Font font = new Font("Arial", Font.BOLD, 28);
        Insets margin = new Insets(0, 0, 0, 0);
        for (int i = 0; i < chessBoardSquares.length; i++) {
            for (int j = 0; j < chessBoardSquares[i].length; j++) {
                final int finalJ = j;
                final int finalI = i;
                JTextField field = new JTextField() {
                    Image image = checkIcon()[finalI][finalJ].getImage();

                    {
                        setOpaque(false);
                    }

                    public void paintComponent(Graphics g) {
                        if ((finalJ % 2 == 1 && finalI % 2 == 1) || (finalJ % 2 == 0 && finalI % 2 == 0)) {
                            g.setColor(Color.BLACK);
                        } else {
                            g.setColor(Color.WHITE);
                        }
                        g.fillRect(1, 1, 600, 600);
                        g.drawImage(image, 10, 30, this);
                        super.paintComponent(g);
                    }
                };
                field.setMargin(margin);

                field.setHorizontalAlignment(JTextField.CENTER);
                field.setFont(font);
                field.setForeground(Color.lightGray);
                field.setText(ChessBoardSingleton.getInstance().getState()[i][j]);
                if ((j % 2 == 1 && i % 2 == 1) || (j % 2 == 0 && i % 2 == 0)) {
                    field.setBackground(Color.WHITE);
                } else {
                    field.setBackground(Color.BLACK);
                }
                chessBoardSquares[j][i] = field;
            }
        }
    }

    /**
     * @return 2D array of icons for squares depending on the squares content
     */
    private static ImageIcon[][] checkIcon() {
        ImageIcon icons[][] = new ImageIcon[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (ChessBoardSingleton.getInstance().getState()[i][j].contains("p")) {
                    icons[i][j] = new ImageIcon("simple//BP.gif");
                } else if (ChessBoardSingleton.getInstance().getState()[i][j].contains("P")) {
                    icons[i][j] = new ImageIcon("simple//WP.gif");
                } else if (ChessBoardSingleton.getInstance().getState()[i][j].contains("q")) {
                    icons[i][j] = new ImageIcon("simple//BQ.gif");
                } else if (ChessBoardSingleton.getInstance().getState()[i][j].contains("Q")) {
                    icons[i][j] = new ImageIcon("simple//WQ.gif");
                } else if (ChessBoardSingleton.getInstance().getState()[i][j].contains("k")) {
                    icons[i][j] = new ImageIcon("simple//BK.gif");
                } else if (ChessBoardSingleton.getInstance().getState()[i][j].contains("K")) {
                    icons[i][j] = new ImageIcon("simple//WK.gif");
                } else if (ChessBoardSingleton.getInstance().getState()[i][j].contains("b")) {
                    icons[i][j] = new ImageIcon("simple//BB.gif");
                } else if (ChessBoardSingleton.getInstance().getState()[i][j].contains("B")) {
                    icons[i][j] = new ImageIcon("simple//WB.gif");
                } else if (ChessBoardSingleton.getInstance().getState()[i][j].contains("r")) {
                    icons[i][j] = new ImageIcon("simple//BR.gif");
                } else if (ChessBoardSingleton.getInstance().getState()[i][j].contains("R")) {
                    icons[i][j] = new ImageIcon("simple//WR.gif");
                } else if (ChessBoardSingleton.getInstance().getState()[i][j].contains("n")) {
                    icons[i][j] = new ImageIcon("simple//BN.gif");
                } else if (ChessBoardSingleton.getInstance().getState()[i][j].contains("N")) {
                    icons[i][j] = new ImageIcon("simple//WN.gif");
                } else
                    icons[i][j] = new ImageIcon();
            }
        }
        return icons;
    }
}