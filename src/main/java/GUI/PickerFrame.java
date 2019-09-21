package GUI;

import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.game.Game;
import com.github.bhlangonijr.chesslib.move.Move;
import com.github.bhlangonijr.chesslib.move.MoveList;
import com.github.bhlangonijr.chesslib.pgn.PgnHolder;
import tools.ConvertFen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;

import static database.InsertData.insertIntoHit;
import static database.InsertData.insertIntoMetaData;
import static singletons.ParseFolderPathSingleton.getInstance;
import static tools.CheckingNulls.checkString;
import static tools.FenHandler.removeWhiteSpaces;
import static tools.LoadFolder.loadFolder;
import static tools.MovesListToStringList.saveMovesToList;

class PickerFrame extends JFrame {

    PickerFrame() {
        final File[] selectedFolder = {new File("example")};
        getInstance().setFiles(loadFolder(selectedFolder[0].getAbsolutePath()));
        setPreferredSize(new Dimension(400, 200));
        setLayout(new GridLayout(3,1));
        final JLabel dirLabel = new JLabel("Directory", JLabel.CENTER);
        dirLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton dirPickerButton = new JButton("Select Folder");
        dirPickerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        dirPickerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                JFileChooser fileChooser = new JFileChooser();
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
                MoveList moves;
                ArrayList<String> movesList;
                Board board;
                ConvertFen converter = new ConvertFen();
                for (int i = 0; i < getInstance().getFiles().length; i++) {
                    games = new ArrayList<>();
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
                        start = System.nanoTime();
                        for (int j = 0; j < games.size(); j++) {
                            try {
                                games.get(j).loadMoveText();
                                insertIntoMetaData
                                        (
                                                games.get(j).getResult().toString(),
                                                Integer.parseInt(games.get(j).getDate().substring(0, 4)),
                                                checkString(games.get(j).getOpening()).replace("'", ""),
                                                games.get(j).getWhitePlayer().toString().replace("'", ""),
                                                games.get(j).getBlackPlayer().toString().replace("'", ""),
                                                games.get(j).getWhitePlayer().getElo(),
                                                games.get(j).getBlackPlayer().getElo()
                                        );

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            moves = games.get(j).getHalfMoves();
                            movesList = saveMovesToList(games.get(j).getMoveText());
                            board = new Board();
                            for (int k = 0; k < moves.size() && k < movesList.size(); k++) {
                                insertIntoHit(movesList.get(k), converter.convert(removeWhiteSpaces(board.getFen())), j + 1);
                                board.doMove(moves.get(k));
                            }
                        }
                        end = System.nanoTime() - start;
                        System.out.println("Zakończono zapisywanie " + getInstance().getFiles()[i].getAbsolutePath());
                        System.out.println("Czas zapisu w ms " + end / 1000000);
                        dispose();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        add(dirPickerButton);
        add(dirLabel);
        add(parsePGNFromFolder);
        setBackground(Color.WHITE);
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
    }
}