package tools;

import com.supareno.pgnparser.jaxb.Game;
import com.supareno.pgnparser.jaxb.Games;
import com.supareno.pgnparser.jaxb.Hits;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class ReadObject {

    public List<Games> deserialzeListOfGames(String filename) {

        List<Games> gamesList = null;

        FileInputStream fin = null;
        ObjectInputStream ois = null;

        try {

            fin = new FileInputStream(filename);
            ois = new ObjectInputStream(fin);
            gamesList = (List<Games>) ois.readObject();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (ois != null) {
                    try {
                        ois.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

            return gamesList;

        }
    }

    public Hits deserialzeHits(String filename) {

        Hits hits = null;

        FileInputStream fin = null;
        ObjectInputStream ois = null;

        try {

            fin = new FileInputStream(filename);
            ois = new ObjectInputStream(fin);
            hits = (Hits) ois.readObject();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (ois != null) {
                    try {
                        ois.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return hits;
        }
    }
}
