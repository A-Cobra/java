import java.util.Scanner;

import utils.BubbleSorter;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
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
        // showing the original contents of the array
        printArrayContents();
        // sorting the array
        BubbleSorter.sortByCapitals(stateCapitalArray);
        // asking questions
        askQuestions();
        System.out.println("Thanks for playing, your score is: " + correctAnswers);
        scanner.close();
    }

    public static void printArrayContents() {
        for (int i = 0; i < stateCapitalArray.length; i++) {
            System.out.println("State name: " + stateCapitalArray[i][0] + ", capital name: " + stateCapitalArray[i][1]);
        }
    }

    private static void askQuestions() {
        for (int i = 0; i < stateCapitalArray.length; i++) {
            System.out.println("Please enter the capital name for the following state: " + stateCapitalArray[i][0]);
            String answer = scanner.nextLine().toLowerCase();
            // we compare the capital name with the input
            if (answer.equals(stateCapitalArray[i][1].toLowerCase())) {
                System.out.println("Correct answer!");
                correctAnswers++;
            } else {
                System.out.println("Incorrect answer. You can do it for the next state.");
            }
        }
    }
}