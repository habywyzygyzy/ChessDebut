package tools;

import java.util.ArrayList;

import static java.lang.Math.pow;

public class ConvertFen {

    public static ArrayList<Long> convert(String fen) {
        Long first, second, third, fourth;
        first = second = third = fourth = 0L;
        ArrayList<Long> converted = new ArrayList<Long>();
        int base = 16;
        char c;
        int i;
        int j = 0;
        for (i = 0; i < base && j < fen.length(); i++) {
            c = fen.charAt(i);
            first += (long) pow(fenValue(c), i);
            j++;
        }
        for (i = 0; i < base && j < fen.length(); i++) {
            c = fen.charAt(i);
            second += (long) pow(fenValue(c), i);
            j++;
        }
        for (i = 0; i < base && j < fen.length(); i++) {
            c = fen.charAt(i);
            third += (long) pow(fenValue(c), i);
            j++;
        }
        for (i = 0; i < base && j < fen.length(); i++) {
            c = fen.charAt(i);
            fourth += (long) pow(fenValue(c), i);
            j++;
        }
        converted.add(first);
        converted.add(second);
        converted.add(third);
        converted.add(fourth);
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
