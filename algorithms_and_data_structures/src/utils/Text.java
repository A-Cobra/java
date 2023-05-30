package utils;

public class Text {
    public static String titleCase(String originalWord) {
        // separate words by a space
        String[] words = originalWord.split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            String capitalized = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
            stringBuilder.append(capitalized).append(" ");
            // append strings from the original word that were separated by a space
        }
        return stringBuilder.toString().trim();
    }
}
