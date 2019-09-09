package GUI;

import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.game.Game;
import com.github.bhlangonijr.chesslib.move.MoveList;
import com.github.bhlangonijr.chesslib.pgn.PgnHolder;
import database.InsertData;
import tools.MovesListToStringList;
import tools.StringToDouble;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import static singletons.ParseFolderPathSingleton.getInstance;
import static tools.FenHandler.removeWhiteSpaces;
import static tools.LoadFolder.loadFolder;

public class PickerPanel extends JPanel {

    public PickerPanel() {
        final File[] selectedFolder = {new File("example")};
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
                PgnHolder pgn;
                ArrayList<Game> games;
                for (int i = 0; i < getInstance().getFiles().length; i++) {
                    games = new ArrayList<Game>();
                    pgn = new PgnHolder(getInstance().getFiles()[i].getAbsolutePath());
                    System.out.println(getInstance().getFiles()[i].getAbsolutePath());
                    try {
                        long start = System.nanoTime();
                        try {
                            pgn.loadPgn();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        games.addAll(pgn.getGame());
                        long end = System.nanoTime() - start;
                        System.out.println("Czas parsowania w ms " + end / 1000000);
                        System.out.println(games.size());
                        for (int j = 0; j < games.size(); j++) {
                            try {
                                games.get(j).loadMoveText();
                                InsertData.insertIntoMetaData(games.get(j).getResult().toString());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            MoveList moves = games.get(j).getHalfMoves();
                            ArrayList<String> movesList = MovesListToStringList.saveMovesToList(games.get(j).getMoveText());
                            Board board = new Board();
                            for (int k = 0; k < moves.size()-1; k++) {
                                InsertData.insertIntoHit(movesList.get(k), StringToDouble.convert(removeWhiteSpaces(board.getFen())), j+1);
                                board.doMove(moves.get(k));
                            }
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
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