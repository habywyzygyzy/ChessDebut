package tools;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Coding {
    //too many decimal places for long strings
    public static double scoreDepthHash(String s) {
        double score = 0;
        double depth = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            score = (int) c * depth + score;
            depth /= 256.0;
        }
        return score;
    }

    public static String makeSHA1Hash(String input)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("SHA1");
        md.reset();
        byte[] buffer = input.getBytes("UTF-8");
        md.update(buffer);
        byte[] digest = md.digest();

        String hexStr = "";
        for (int i = 0; i < digest.length; i++) {
            hexStr += Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1);
        }
        return hexStr;
    }
}
