package tools;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class StringToDouble {
    public static double convert(String fen){
        double converted = 0;
        int positive=1;
        int negative=-1;
        char c;
        for (int i =0;i<fen.length();i++){
            c = fen.charAt(i);
            if(abs(positive)==abs(negative)){
                converted += pow(fenValue(c),positive);
                positive++;
            }
            else{
                converted += pow(fenValue(c),negative);
                negative--;
            }
        }
        return converted;
    }

    private static int fenValue(char c) {
        int value = 0;
        switch (c){
            case 'p':
                value=1;
                break;
            case 'P':
                value=2;
                break;
            case '/':
                value=3;
                break;
            case 'r':
                value=4;
                break;
            case 'n':
                value=5;
                break;
            case 'b':
                value=6;
                break;
            case 'R':
                value=7;
                break;
            case 'N':
                value=8;
                break;
            case 'B':
                value=9;
                break;
            case 'q':
                value=10;
                break;
            case 'Q':
                value=11;
                break;
            case 'k':
                value=12;
                break;
            case 'K':
                value=13;
                break;
            case '1':
                value=14;
                break;
            case '2':
                value=15;
                break;
            case '3':
                value=16;
                break;
            case '4':
                value=17;
                break;
            case '5':
                value=18;
                break;
            case '6':
                value=19;
                break;
            case '7':
                value=20;
                break;
            case '8':
                value=21;
                break;
            case 'w':
                value=22;
                break;
            default:
                value=0;
                break;
        }
        return value;
    }
}
