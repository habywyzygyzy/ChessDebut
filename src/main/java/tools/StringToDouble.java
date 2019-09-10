package tools;

import java.util.ArrayList;

import static java.lang.Math.pow;

public class StringToDouble {
    /*public static double convert(String fen) {
        double converted = 0;
        int positive = 1;
        int negative = -1;
        char c;
        if (fen.endsWith("-")) {
            for (int i = 0; i < fen.length() - 1; i++) {
                c = fen.charAt(i);
                if (abs(positive) == abs(negative)) {
                    converted += pow(fenValue(c), positive);
                    positive++;
                } else {
                    converted += pow(fenValue(c), negative);
                    negative--;
                }
            }
            if (abs(positive) == abs(negative)) {
                converted += pow(23, positive);
            } else {
                converted += pow(23, negative);
            }
        } else if (fen.endsWith("KQkq")) {
            positive = 1;
            negative = -1;
            for (int i = 0; i < fen.length() - 4; i++) {
                c = fen.charAt(i);
                if (abs(positive) == abs(negative)) {
                    converted += pow(fenValue(c), positive);
                    positive++;
                } else {
                    converted += pow(fenValue(c), negative);
                    negative--;
                }
            }
            if (abs(positive) == abs(negative)) {
                converted += pow(24, positive);
            } else {
                converted += pow(24, negative);
            }
        } else if (fen.endsWith("KQ")) {
            positive = 1;
            negative = -1;
            for (int i = 0; i < fen.length() - 2; i++) {
                c = fen.charAt(i);
                if (abs(positive) == abs(negative)) {
                    converted += pow(fenValue(c), positive);
                    positive++;
                } else {
                    converted += pow(fenValue(c), negative);
                    negative--;
                }
            }
            if (abs(positive) == abs(negative)) {
                converted += pow(25, positive);
            } else {
                converted += pow(25, negative);
            }
        } else if (fen.endsWith("kq")) {
            positive = 1;
            negative = -1;
            for (int i = 0; i < fen.length() - 2; i++) {
                c = fen.charAt(i);
                if (abs(positive) == abs(negative)) {
                    converted += pow(fenValue(c), positive);
                    positive++;
                } else {
                    converted += pow(fenValue(c), negative);
                    negative--;
                }
            }
            if (abs(positive) == abs(negative)) {
                converted += pow(26, positive);
            } else {
                converted += pow(26, negative);
            }
        }
        return converted;
    }*/

    /*public static double convert2(String fen) {
        double converted = 0;
        char c;
        int i = 0;
        if (fen.endsWith("-")) {
            for (i = 0; i < fen.length() - 1; i++) {
                c = fen.charAt(i);
                converted += pow(fenValue(c), i);
                converted += pow(23, i);
            }
        } else if (fen.endsWith("KQkq")) {
            for (i = 0; i < fen.length() - 4; i++) {
                c = fen.charAt(i);
                converted += pow(fenValue(c), i);
            }
            converted += pow(24, i);
        } else if (fen.endsWith("KQ")) {
            for (i = 0; i < fen.length() - 2; i++) {
                c = fen.charAt(i);
                converted += pow(fenValue(c), i);
            }
            converted += pow(25, i);
        } else if (fen.endsWith("kq")) {
            for (i = 0; i < fen.length() - 2; i++) {
                c = fen.charAt(i);
                converted += pow(fenValue(c), i);
            }
            converted += pow(26, i);
        }
        BigDecimal value = new BigDecimal(converted);
        value.setScale(400);
        System.out.println(value);
        System.out.println(fen);
        System.out.println(fen.length());
        return converted;
    }*/

    public static ArrayList<Long> convert(String fen) {
        Long first, second, third, fourth, fifth, sixth;
        first = second = third = fourth = fifth = sixth = new Long(0);
        ArrayList<Long> converted = new ArrayList<Long>();
        int base = 16;
        char c;
        int i = 0;
        if (fen.endsWith("-")) {
            int j = 0;
            for (i = 0; i < base && j < fen.length() - 1; i++) {
                c = fen.charAt(i);
                first += (long) pow(fenValue(c), i);
                j++;
            }
            for (i = 0; i < base && j < fen.length() - 1; i++) {
                c = fen.charAt(i);
                second += (long) pow(fenValue(c), i);
                j++;
            }
            for (i = 0; i < base && j < fen.length() - 1; i++) {
                c = fen.charAt(i);
                third += (long) pow(fenValue(c), i);
                j++;
            }
            for (i = 0; i < base && j < fen.length() - 1; i++) {
                c = fen.charAt(i);
                fourth += (long) pow(fenValue(c), i);
                j++;
            }
            /*for (i = 0; i < base && j < fen.length() - 1; i++) {
                c = fen.charAt(i);
                fifth += (long) pow(fenValue(c), i);
                j++;
            }
            for (i = 0; i < base && j < fen.length() - 1; i++) {
                c = fen.charAt(i);
                sixth += (long) pow(fenValue(c), i);
                j++;
            }*/
            fourth += (long) pow(23, i);
        } else if (fen.endsWith("KQkq")) {
            int j = 0;
            for (i = 0; i < base && j < fen.length() - 4; i++) {
                c = fen.charAt(i);
                first += (long) pow(fenValue(c), i);
                j++;
            }
            for (i = 0; i < base && j < fen.length() - 4; i++) {
                c = fen.charAt(i);
                second += (long) pow(fenValue(c), i);
                j++;
            }
            for (i = 0; i < base && j < fen.length() - 4; i++) {
                c = fen.charAt(i);
                third += (long) pow(fenValue(c), i);
                j++;
            }
            for (i = 0; i < base && j < fen.length() - 4; i++) {
                c = fen.charAt(i);
                fourth += (long) pow(fenValue(c), i);
                j++;
            }
            /*for (i = 0; i < base && j < fen.length() - 4; i++) {
                c = fen.charAt(i);
                fifth += (long) pow(fenValue(c), i);
                j++;
            }
            for (i = 0; i < base && j < fen.length() - 4; i++) {
                c = fen.charAt(i);
                sixth += (long) pow(fenValue(c), i);
                j++;
            }*/
            fourth += (long) pow(24, i);
        } else if (fen.endsWith("KQ")) {
            int j = 0;
            for (i = 0; i < base && j < fen.length() - 2; i++) {
                c = fen.charAt(i);
                first += (long) pow(fenValue(c), i);
                j++;
            }
            for (i = 0; i < base && j < fen.length() - 2; i++) {
                c = fen.charAt(i);
                second += (long) pow(fenValue(c), i);
                j++;
            }
            for (i = 0; i < base && j < fen.length() - 2; i++) {
                c = fen.charAt(i);
                third += (long) pow(fenValue(c), i);
                j++;
            }
            for (i = 0; i < base && j < fen.length() - 2; i++) {
                c = fen.charAt(i);
                fourth += (long) pow(fenValue(c), i);
                j++;
            }
            /*for (i = 0; i < base && j < fen.length() - 2; i++) {
                c = fen.charAt(i);
                fifth += (long) pow(fenValue(c), i);
                j++;
            }
            for (i = 0; i < base && j < fen.length() - 2; i++) {
                c = fen.charAt(i);
                sixth += (long) pow(fenValue(c), i);
                j++;
            }*/
            fourth += (long) pow(25, i);
        } else if (fen.endsWith("kq")) {
            int j = 0;
            for (i = 0; i < base && j < fen.length() - 2; i++) {
                c = fen.charAt(i);
                first += (long) pow(fenValue(c), i);
                j++;
            }
            for (i = 0; i < base && j < fen.length() - 2; i++) {
                c = fen.charAt(i);
                second += (long) pow(fenValue(c), i);
                j++;
            }
            for (i = 0; i < base && j < fen.length() - 2; i++) {
                c = fen.charAt(i);
                third += (long) pow(fenValue(c), i);
                j++;
            }
            for (i = 0; i < base && j < fen.length() - 2; i++) {
                c = fen.charAt(i);
                fourth += (long) pow(fenValue(c), i);
                j++;
            }
            /*for (i = 0; i < base && j < fen.length() - 2; i++) {
                c = fen.charAt(i);
                fifth += (long) pow(fenValue(c), i);
                j++;
            }
            for (i = 0; i < base && j < fen.length() - 2; i++) {
                c = fen.charAt(i);
                sixth += (long) pow(fenValue(c), i);
                j++;
            }*/
            fourth += (long) pow(26, i);
        }
        converted.add(first);
        converted.add(second);
        converted.add(third);
        converted.add(fourth);
        //converted.add(fifth);
        //converted.add(sixth);
        return converted;
    }

    private static int fenValue(char c) {
        int value;
        switch (c) {
            case 'p':
                value = 1;
                break;
            case 'P':
                value = 2;
                break;
            case '/':
                value = 3;
                break;
            case 'r':
                value = 4;
                break;
            case 'n':
                value = 5;
                break;
            case 'b':
                value = 6;
                break;
            case 'R':
                value = 7;
                break;
            case 'N':
                value = 8;
                break;
            case 'B':
                value = 9;
                break;
            case 'q':
                value = 10;
                break;
            case 'Q':
                value = 11;
                break;
            case 'k':
                value = 12;
                break;
            case 'K':
                value = 13;
                break;
            case '1':
                value = 14;
                break;
            case '2':
                value = 15;
                break;
            case '3':
                value = 16;
                break;
            case '4':
                value = 17;
                break;
            case '5':
                value = 18;
                break;
            case '6':
                value = 19;
                break;
            case '7':
                value = 20;
                break;
            case '8':
                value = 21;
                break;
            case 'w':
                value = 22;
                break;
            default:
                value = 0;
                break;
        }
        return value;
    }
}
