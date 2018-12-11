package tools;

import com.supareno.pgnparser.jaxb.Game;
import com.supareno.pgnparser.jaxb.Games;
import com.supareno.pgnparser.jaxb.Hit;
import com.supareno.pgnparser.jaxb.Hits;

import java.util.List;

public class PrintDebug {

    public static void printGames(List<Games> gamesList, TypeOfPrintedMoves type) {
        for (Games games : gamesList) {
            printGame(games, type);
        }
    }

    public static void printGame(Games games, TypeOfPrintedMoves type) {
        Hits hits;
        List<Hit> hit;
        for (Game game : games.getGame()) {
            System.out.println("Moves");
            hits = game.getHits();
            hit = hits.getHit();
            for (Hit hit1 : hit) {
                printMove(hit1, type);
            }
            System.out.println(game.getResult());

            System.out.println("______________________________________");
        }
    }

    public static void printMove(Hit hit1, TypeOfPrintedMoves type) {
        if (type == TypeOfPrintedMoves.ALL)
            System.out.println(hit1.getNumber() + " " + hit1.getContent());
        else if (type == TypeOfPrintedMoves.BLACK)
            System.out.println(hit1.getNumber() + " " + getBlackMove(hit1));
        else
            System.out.println(hit1.getNumber() + " " + getWhiteMove(hit1));
    }

    public static String getBlackMove(Hit hit1) {

        String str = hit1.getContent();
        str = str.substring(str.indexOf(' ') + 1);
        return str;
    }

    private static String getWhiteMove(Hit hit1) {
        return hit1.getContent().replaceAll(" .+$", "");
    }

    public enum TypeOfPrintedMoves {
        WHITE, BLACK, ALL;
    }
}
