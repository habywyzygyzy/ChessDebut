package tools;

import models.Statistics;

import java.util.Comparator;

/**
 * Sort Statisctics for white player
 */
public class SortForWhites implements Comparator<Statistics> {
    /**
     * @param o1 First element to compare
     * @param o2 Second element to compare
     * @return Difference between whiteWins of neighboring elements
     */
    @Override
    public int compare(Statistics o1, Statistics o2) {
        return o1.getWhiteWins() - o2.getWhiteWins();
    }
}
