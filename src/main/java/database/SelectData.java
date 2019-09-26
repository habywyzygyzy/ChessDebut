package database;

import models.Statistics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static singletons.ChessBoardSingleton.getIsWhiteMove;
import static singletons.DatabaseConfigSingleton.getConn;
import static singletons.FiltersSingleton.*;

/**
 * Select data from database
 */
public class SelectData {

    /**
     * Selects data with the same FEN
     *
     * @param FEN Chessboard in FEN format
     * @return List of statistics for current chessboard state
     */
    public static ArrayList<Statistics> selectHitsWithTheSameFEN(long[] FEN) {
        ArrayList<Statistics> stats = new ArrayList<Statistics>();
        java.sql.PreparedStatement preparedStatement = null;
        String minELO;
        String maxELO = "";
        String gameYear = "";
        String name = "";
        String opening = "";
        String select =
                "SELECT `Moves`.MetaId," +
                        " `Moves`.Hit," +
                        " `MetaData`.`Result`," +
                        " `MetaData`.`WhiteELO`," +
                        " `MetaData`.`BlackELO`," +
                        " `MetaData`.`GameYear`," +
                        " `MetaData`.`WhiteName`," +
                        " `MetaData`.`BlackName`," +
                        " `MetaData`.`Opening` ";
        String from = "FROM `Moves` ";
        String join = "JOIN `MetaData` ";
        String on = "ON (`Moves`.`MetaId` = `MetaData`.`MetaId`) ";
        String where = "WHERE `StateBeforeHit`  = '" + FEN[0] + "'";
        String and = "AND `StateBeforeHit2`  = '" + FEN[1] + "'";
        String and2 = "AND `StateBeforeHit3`  = '" + FEN[2] + "'";
        String and3 = "AND `StateBeforeHit4`  = '" + FEN[3] + "'";
        if (getIsWhiteMove()) {
            minELO = "AND `MetaData`.`WhiteELO` > '" + getMinELO() + "'";
            if (getMaxELO() > getMinELO())
                maxELO = "AND `MetaData`.`WhiteELO` < '" + getMaxELO() + "'";
        } else {
            minELO = "AND `MetaData`.`BlackELO` > '" + getMinELO() + "'";
            if (getMaxELO() > getMinELO())
                maxELO = "AND `MetaData`.`BlackELO` < '" + getMaxELO() + "'";
        }
        if (getYear() > 0)
            gameYear = "AND `MetaData`.`GameYear` > '" + getYear() + "'";
        if (!getName().isEmpty())
            if (getIsWhiteMove())
                name = "AND `MetaData`.`WhiteName` = '" + getName() + "'";
            else
                name = "AND `MetaData`.`BlackName` = '" + getName() + "'";
        if (!getOpening().isEmpty())
            opening = "AND `MetaData`.`Opening` = '" + getOpening() + "'";

        String sql = select + from + join + on + where + and + and2 + and3 + minELO + maxELO + gameYear + name + opening;
        System.out.println(sql);
        try {
            preparedStatement = getConn().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            Statistics stat;
            ArrayList<String> possibleHits = new ArrayList<String>();
            int hitIndex;
            while (rs.next()) {
                stat = new Statistics(0, 0, 0, "");
                hitIndex = possibleHits.indexOf(rs.getString(2));
                if (hitIndex == -1) {
                    possibleHits.add(rs.getString(2));
                    stat.setHit(rs.getString(2));
                    if (rs.getString(3).equals("BLACK_WON"))
                        stat.setBlackWins(stat.getBlackWins() + 1);
                    else if (rs.getString(3).equals("WHITE_WON"))
                        stat.setWhiteWins(stat.getWhiteWins() + 1);
                    else
                        stat.setDraws(stat.getDraws() + 1);
                    stats.add(stat);
                } else {
                    stats.get(hitIndex).setHit(possibleHits.get(hitIndex));
                    if (rs.getString(3).equals("BLACK_WON"))
                        stats.get(hitIndex).setBlackWins(stats.get(hitIndex).getBlackWins() + 1);
                    else if (rs.getString(3).equals("WHITE_WON"))
                        stats.get(hitIndex).setWhiteWins(stats.get(hitIndex).getWhiteWins() + 1);
                    else
                        stats.get(hitIndex).setDraws(stats.get(hitIndex).getDraws() + 1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stats;
    }
}
