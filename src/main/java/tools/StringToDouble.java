package tools;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class StringToDouble {
    public static double convert(String fen) {
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
