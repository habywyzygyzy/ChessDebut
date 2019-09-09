package database;

import models.Statistics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static singletons.DatabaseConfigSingleton.getConn;

public class SelectData {
    /*public static ArrayList<String> testSelect() {
        ArrayList<String> test = new ArrayList<String>();
        java.sql.PreparedStatement preparedStatement = null;
        String sql = "SELECT Result FROM MetaData";
        try {
            preparedStatement = getConn().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next())
                test.add(rs.getString(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return test;
    }*/

    public static ArrayList<Statistics> selectHitsWithTheSameFEN(double FEN) {
        ArrayList<String> test = new ArrayList<String>();
        ArrayList<Statistics> stats = new ArrayList<Statistics>();
        java.sql.PreparedStatement preparedStatement = null;
        String select = "SELECT Hit.MetaId, Hit.Hit, MetaData.Result ";
        String from = "FROM Hit ";
        String join = "JOIN MetaData ";
        String on = "ON (Hit.MetaId = MetaData.MetaId) ";
        String where = "WHERE StateBeforeHit  = '" + FEN + "'";
        String sql = select + from + join + on + where;
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
