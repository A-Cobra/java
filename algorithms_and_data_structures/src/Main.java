import java.io.InputStream;
import java.util.Scanner;

import utils.BubbleSorter;

public class Main {
    private static int correctAnswers = 0;
    private static String[][] stateCapitalArray = {
            { "Alabama", "Montgomery" },
            { "Alaska", "Juneau" },
            { "Arizona", "Phoenix" },
            { "Arkansas", "Little Rock" },
            { "California", "Sacramento" },
            { "Colorado", "Denver" },
            { "Connecticut", "Hartford" },
            { "Delaware", "Dover" },
            { "Florida", "Tallahassee" },
            { "Georgia", "Atlanta" },
            { "Hawaii", "Honolulu" },
            { "Idaho", "Boise" },
            { "Illinois", "Springfield" },
            { "Indiana", "Indianapolis" },
            { "Iowa", "Des Moines" },
            { "Kansas", "Topeka" },
            { "Kentucky", "Frankfort" },
            { "Louisiana", "Baton Rouge" },
            { "Maine", "Augusta" },
            { "Maryland", "Annapolis" },
            { "Massachusetts", "Boston" },
            { "Michigan", "Lansing" },
            { "Minnesota", "Saint Paul" },
            { "Mississippi", "Jackson" },
            { "Missouri", "Jefferson City" },
            { "Montana", "Helena" },
            { "Nebraska", "Lincoln" },
            { "Nevada", "Carson City" },
            { "New Hampshire", "Concord" },
            { "New Jersey", "Trenton" },
            { "New Mexico", "Santa Fe" },
            { "New York", "Albany" },
            { "North Carolina", "Raleigh" },
            { "North Dakota", "Bismarck" },
            { "Ohio", "Columbus" },
            { "Oklahoma", "Oklahoma City" },
            { "Oregon", "Salem" },
            { "Pennsylvania", "Harrisburg" },
            { "Rhode Island", "Providence" },
            { "South Carolina", "Columbia" },
            { "South Dakota", "Pierre" },
            { "Tennessee", "Nashville" },
            { "Texas", "Austin" },
            { "Utah", "Salt Lake City" },
            { "Vermont", "Montpelier" },
            { "Virginia", "Richmond" },
            { "Washington", "Olympia" },
            { "West Virginia", "Charleston" },
            { "Wisconsin", "Madison" },
            { "Wyoming", "Cheyenne" }
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // showing the original contents of the array
        printArrayContents();
        // sorting the array
        System.out.println("Sorted by capital");
        BubbleSorter.sortText(stateCapitalArray);
        printArrayContents();
        scanner.close();
        // int[] unsortedArray = { 14, 7, 23, 186, 4, 854, 1, 9 };
        // for (int number : unsortedArray) {
        // System.out.println("NUmber: " + number);
        // }
        // System.out.println("Sorted");
        // BubbleSorter.sort(unsortedArray);
        // for (int number : unsortedArray) {
        // System.out.println("NUmber: " + number);
        // }
    }

    public static void printArrayContents() {
        for (int i = 0; i < stateCapitalArray.length; i++) {
            System.out.println("State name: " + stateCapitalArray[i][0] + ", capital name: " + stateCapitalArray[i][1]);
        }
    }
}