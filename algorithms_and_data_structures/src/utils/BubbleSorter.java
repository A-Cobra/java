package utils;

public class BubbleSorter {
    public static void sortByColumnNumber(String[][] originalArray, int column, boolean ascending) {
        if (column > 1)
            return;
        int arrayLength = originalArray.length;
        if (ascending) {
            for (int i = 0; i < arrayLength - 1; i++) {
                for (int j = 0; j < arrayLength - i - 1; j++) {
                    String str2 = originalArray[j + 1][column];
                    String str1 = originalArray[j][column];
                    int result = str1.compareTo(str2);
                    // string1 is greater than string 2
                    if (result > 0) {
                        // we exchange them
                        String[] temp = originalArray[j];
                        originalArray[j] = originalArray[j + 1];
                        originalArray[j + 1] = temp;
                    }
                }
                // at the end of each iteration, the sub array number with the 'greatest' column
                // value be at the last index
            }
        } else {
            for (int i = 0; i < arrayLength - 1; i++) {
                for (int j = 0; j < arrayLength - i - 1; j++) {
                    String str2 = originalArray[j + 1][column];
                    String str1 = originalArray[j][column];
                    int result = str1.compareTo(str2);
                    // string1 is greater than string 2
                    if (result < 0) {
                        // we exchange them
                        String[] temp = originalArray[j];
                        originalArray[j] = originalArray[j + 1];
                        originalArray[j + 1] = temp;
                    }
                }
                // at the end of each iteration, the sub array number with the 'greatest' column
                // value be at the last index
            }
        }

    }

    public static void sort2dStringArray(String[][] originalArray) {
        int column = 0;
        boolean ascending = true;
        sortByColumnNumber(originalArray, column, ascending);
    }

    public static void sortByCapitals(String[][] originalArray) {
        int column = 1;
        boolean ascending = true;
        sortByColumnNumber(originalArray, column, ascending);
    }
}
