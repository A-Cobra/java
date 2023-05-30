package utils;

import java.util.Map;

public class Printer {
    public static void printArrayContents(String[][] stateCapitalArray) {
        System.out.println();
        System.out.println();
        System.out.println("Printing a 2d string array");
        for (int i = 0; i < stateCapitalArray.length; i++) {
            System.out.println("State name: " + stateCapitalArray[i][0] + ", capital name: " + stateCapitalArray[i][1]);
        }
    }

    public static void printMapContents(Map<String, String> stateCapitalMap, String mapType) {
        System.out.println();
        System.out.println();
        System.out.println("From the " + mapType + " map");
        for (Map.Entry<String, String> subMap : stateCapitalMap.entrySet()) {
            System.out.println("Key = " + subMap.getKey() + ", Value = " + subMap.getValue());
        }
    }
}
