package GUI;

import singletons.ChessBoardSingleton;

import javax.swing.*;
import java.awt.*;

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
     * @param chessBoardPanel   Panel with chessboard
     * @param chessBoardSquares 2D array of squares inside chessboard
     */
    static void addSquaresToBoard(JPanel chessBoardPanel, JTextField[][] chessBoardSquares) {
        int k = 8;
        JLabel label = null;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (j == 0) {
                    label = new JLabel(String.valueOf(k) + "   ", SwingConstants.RIGHT);
                    label.setFont(new Font("Arial", Font.BOLD, 24));
                    chessBoardPanel.add(label);
                }
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
        //GridBagConstraints gbc = new GridBagConstraints();
        chessBoardPanel.add(new JLabel(""));
        JLabel label = null;
        for (int i = 0; i < 8; i++) {
            //setConstraintsForColumnLabel(gbc, i);
            label = new JLabel("abcdefgh".substring(i, i + 1), SwingConstants.CENTER);
            label.setVerticalAlignment(JLabel.TOP);
            label.setVerticalTextPosition(JLabel.TOP);
            label.setFont(new Font("Arial", Font.BOLD, 24));
            chessBoardPanel.add(label);
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
                            g.setColor(new Color(232, 235, 239));
                        } else {
                            g.setColor(new Color(125, 135, 150));
                        }
                        g.fillRect(1, 1, 600, 600);
                        g.drawImage(image, 10, 30, this);
                        super.paintComponent(g);
                    }
                };
                field.setMargin(margin);

                field.setHorizontalAlignment(JTextField.CENTER);
                field.setFont(font);
                field.setForeground(Color.BLACK);
                field.setText(ChessBoardSingleton.getInstance().getState()[i][j]);
                chessBoardSquares[j][i] = field;
            }
        }
    }

    /**
     * @return 2D array of icons for squares depending on the squares content
     */
    private static ImageIcon[][] checkIcon() {
        ImageIcon[][] icons = new ImageIcon[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (ChessBoardSingleton.getInstance().getState()[i][j].contains("p")) {
                    icons[i][j] = new ImageIcon("icons//BP.gif");
                } else if (ChessBoardSingleton.getInstance().getState()[i][j].contains("P")) {
                    icons[i][j] = new ImageIcon("icons//WP.gif");
                } else if (ChessBoardSingleton.getInstance().getState()[i][j].contains("q")) {
                    icons[i][j] = new ImageIcon("icons//BQ.gif");
                } else if (ChessBoardSingleton.getInstance().getState()[i][j].contains("Q")) {
                    icons[i][j] = new ImageIcon("icons//WQ.gif");
                } else if (ChessBoardSingleton.getInstance().getState()[i][j].contains("k")) {
                    icons[i][j] = new ImageIcon("icons//BK.gif");
                } else if (ChessBoardSingleton.getInstance().getState()[i][j].contains("K")) {
                    icons[i][j] = new ImageIcon("icons//WK.gif");
                } else if (ChessBoardSingleton.getInstance().getState()[i][j].contains("b")) {
                    icons[i][j] = new ImageIcon("icons//BB.gif");
                } else if (ChessBoardSingleton.getInstance().getState()[i][j].contains("B")) {
                    icons[i][j] = new ImageIcon("icons//WB.gif");
                } else if (ChessBoardSingleton.getInstance().getState()[i][j].contains("r")) {
                    icons[i][j] = new ImageIcon("icons//BR.gif");
                } else if (ChessBoardSingleton.getInstance().getState()[i][j].contains("R")) {
                    icons[i][j] = new ImageIcon("icons//WR.gif");
                } else if (ChessBoardSingleton.getInstance().getState()[i][j].contains("n")) {
                    icons[i][j] = new ImageIcon("icons//BN.gif");
                } else if (ChessBoardSingleton.getInstance().getState()[i][j].contains("N")) {
                    icons[i][j] = new ImageIcon("icons//WN.gif");
                } else
                    icons[i][j] = new ImageIcon();
            }
        }
        return icons;
    }

    private static void setConstraintsForColumnLabel(GridBagConstraints gbc, int pos) {
        gbc.gridx = pos;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        //gbc.weightx = 100;
        //gbc.weighty = 5;
        gbc.anchor = GridBagConstraints.SOUTH;
    }
}