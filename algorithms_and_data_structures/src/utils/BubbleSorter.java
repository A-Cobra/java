package utils;

public class BubbleSorter {
    private static String[][] sortByColumnNumber(String[][] originalArray, int column) {
        String[][] arr = { { "Hola", "Mundo" }, { "Java", "es", "genial" } };
        return arr;
    }

    public static void sortText(String[][] originalArray) {
        int column = 1;
        int arrayLength = originalArray.length;
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
    }

    public static int[] sort(int[] originalArray, boolean ascending) {
        int arrayLength = originalArray.length;
        if (ascending) {
            for (int i = 0; i < arrayLength - 1; i++) {
                for (int j = 0; j < arrayLength - i - 1; j++) {
                    if (originalArray[j] > originalArray[j + 1]) {
                        // swapping numbers
                        int temp = originalArray[j];
                        originalArray[j] = originalArray[j + 1];
                        originalArray[j + 1] = temp;
                    }
                }
                // at the end of each iteration, the biggest number will be at the last index
            }
        } else {
            for (int i = 0; i < arrayLength - 1; i++) {
                for (int j = 0; j < arrayLength - i - 1; j++) {
                    if (originalArray[j] < originalArray[j + 1]) {
                        // swapping numbers
                        int temp = originalArray[j];
                        originalArray[j] = originalArray[j + 1];
                        originalArray[j + 1] = temp;
                    }
                }
                // at the end of each iteration, the biggest number will be at the last index
            }
        }
        return originalArray;
    }

    public static int[] sort(int[] originalArray) {
        return sort(originalArray, true);
    }
}
