package utils;

public class Text {
    public static String titleCase(String originalWord) {
        String[] words = originalWord.split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            String capitalized = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
            stringBuilder.append(capitalized).append(" ");
        }
        return stringBuilder.toString().trim();
    }
}
