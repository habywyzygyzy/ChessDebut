package tools;

import java.util.Arrays;

/**
 * Converts chess board in FEN format to array of longs
 */
public class ConvertFen {

    private int[] map = new int[128];

    /**
     * Initialize map values
     */
    public ConvertFen() {
        Arrays.fill(map, 0);
        map[(byte) 'p'] = 1;
        map[(byte) 'P'] = 2;
        map[(byte) '/'] = 3;
        map[(byte) 'k'] = 4;
        map[(byte) 'q'] = 5;
        map[(byte) 'K'] = 6;
        map[(byte) 'Q'] = 7;
        map[(byte) 'b'] = 8;
        map[(byte) 'n'] = 9;
        map[(byte) 'r'] = 10;
        map[(byte) 'R'] = 11;
        map[(byte) 'N'] = 12;
        map[(byte) 'B'] = 13;
        map[(byte) '1'] = 14;
        map[(byte) '2'] = 15;
        map[(byte) '3'] = 16;
        map[(byte) '4'] = 17;
        map[(byte) '5'] = 18;
        map[(byte) '6'] = 19;
        map[(byte) '7'] = 20;
        map[(byte) '8'] = 21;
    }

    /**
     * @param fen Chess Board in FEN format
     * @return fen converted to array of longs
     */
    public long[] convert(String fen) {
        int arrLength = 4;
        long[] converted = new long[arrLength];
        int base = 16;
        char c;
        int i;
        int j = 0;
        for (int k = 0; k < arrLength; k++) {
            for (i = 0; i < base && j < fen.length(); i++) {
                c = fen.charAt(j);
                converted[k] += powLong(fenValue(c), i);
                j++;
            }
        }
        return converted;
    }

    /**
     * @param c Char to be mapped
     * @return Int value for mapped char
     */
    private int fenValue(char c) {
        return this.map[(byte) c];
    }

    /**
     * Exponentiation for long type
     * @param value Value to be raised
     * @param exponent Exponent for the value
     * @return value to the power of exponent
     */
    private static long powLong(int value, int exponent) {
        long ret = 1;
        for (int i = 0; i < exponent; i++) {
            ret *= value;
        }
        return ret;
    }
}