package models;

/**
 * Model that holds statisctics of a move
 */
public class Statistics {
    private int blackWins;
    private int whiteWins;
    private int draws;
    private String hit;

    /**
     * @param blackWins How many times black player won after this move was used
     * @param whiteWins How many times white player won after this move was used
     * @param draws     How many times draw occured after this move was used
     * @param hit       Move
     */
    public Statistics(int blackWins, int whiteWins, int draws, String hit) {
        this.blackWins = blackWins;
        this.whiteWins = whiteWins;
        this.draws = draws;
        this.hit = hit;
    }

    public int getBlackWins() {
        return blackWins;
    }

    public void setBlackWins(int blackWins) {
        this.blackWins = blackWins;
    }

    public int getWhiteWins() {
        return whiteWins;
    }

    public void setWhiteWins(int whiteWins) {
        this.whiteWins = whiteWins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public String getHit() {
        return hit;
    }

    public void setHit(String hit) {
        this.hit = hit;
    }


}
