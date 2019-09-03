package tools;

class Generator {
    static String generate(){
        final String ALPHA_NUMERIC_STRING = "rnbqkp/RNBQKP12345678-w";
        StringBuilder builder = new StringBuilder();
        int count = 50;
        while (count-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }
}
