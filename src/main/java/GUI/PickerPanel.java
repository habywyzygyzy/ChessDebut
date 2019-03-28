package GUI;

import com.github.bhlangonijr.chesslib.game.Game;
import com.github.bhlangonijr.chesslib.pgn.PgnHolder;
import database.DBExecutor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import static singletons.ParseFolderPathSingleton.getInstance;
import static tools.LoadFolder.loadFolder;

public class PickerPanel extends JPanel {

    public PickerPanel() {
        final File[] selectedFolder = {new File("C:\\Users\\Kamil\\Desktop\\Politechnika\\INZ\\ChessDebut\\example")};
        getInstance().setFiles(loadFolder(selectedFolder[0].getAbsolutePath()));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        final JLabel dirLabel = new JLabel("Directory", JLabel.CENTER);
        dirLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton dirPickerButton = new JButton("Select Folder");
        dirPickerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        dirPickerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                JFileChooser fileChooser = new JFileChooser();
                File[] files = new File[0];
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                fileChooser.setAcceptAllFileFilterUsed(false);
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    selectedFolder[0] = fileChooser.getSelectedFile();
                    dirLabel.setText(selectedFolder[0].getAbsolutePath());
                    getInstance().setFiles(loadFolder(selectedFolder[0].getPath()));
                }
            }
        });

        JButton parsePGNFromFolder = new JButton("Parse");
        parsePGNFromFolder.setAlignmentX(Component.CENTER_ALIGNMENT);
        parsePGNFromFolder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                PgnHolder pgn = null;
                ArrayList<Game> games = new ArrayList<Game>();

                for (int i = 0; i < getInstance().getFiles().length; i++) {
                    pgn = new PgnHolder(getInstance().getFiles()[i].getAbsolutePath());
                    try {
                        long start = System.nanoTime();
                        pgn.loadPgn();
                        games.addAll(pgn.getGame());
                        long end = System.nanoTime() - start;
                        System.out.println("Czas parsowania w ms " + end / 1000000);
                        System.out.println(games.size());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                /*for (Game game : games) {
                    try {
                        game.loadMoveText();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    MoveList moves = game.getHalfMoves();
                    Board board = new Board();
                    //Replay all the moves from the game and print the final position in FEN format
                    for (Move move : moves) {
                        board.doMove(move);
                    }
                    System.out.println("FEN: " + board.getFen());
                }*/

                //                PGNParser parser = new PGNParser();
                /*Games games = new Games();
                for (int i = 0; i < ParseFolderPathSingleton.getInstance().getFiles().length; i++)
                    games = parser.parseFile(ParseFolderPathSingleton.getInstance().getFiles()[i]);*/
                DBExecutor db = new DBExecutor();
                db.Test();
            }
        });
        this.add(dirPickerButton);
        this.add(Box.createRigidArea(new Dimension(5, 10)));
        this.add(dirLabel);
        this.add(Box.createRigidArea(new Dimension(5, 10)));
        this.add(parsePGNFromFolder);
        this.setBackground(Color.WHITE);
        this.setVisible(true);
    }
}