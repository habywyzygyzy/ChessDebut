package tools;

import models.Statistics;

import java.util.Comparator;

public class SortForBlacks implements Comparator<Statistics> {
    @Override
    public int compare(Statistics o1, Statistics o2) {
        return o1.getBlackWins() - o2.getBlackWins();
    }
}
