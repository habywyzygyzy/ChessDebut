package tools;

/**
 * Check if object is null
 */
public class CheckingNulls {
    /**
     * @param string String, that will be checked
     * @return Given string if is not null, empty string if given is null
     */
    public static String checkString(String string) {
        if (string != null)
            return string;
        else
            return "";
    }
}