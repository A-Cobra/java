import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import utils.BubbleSorter;
import utils.Printer;
import utils.Text;

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
    private static Map<String, String> stateCapitalMap = new HashMap<String, String>();
    private static TreeMap<String, String> stateCapitalTreeMap = new TreeMap<String, String>();

    public static void main(String[] args) {
        boolean alreadySorted = false;
        boolean alreadyFilledMaps = false;
        // creating as menu item
        Menu menu = new Menu();
        while (menu.isRunning()) {
            menu.show();
            int chosenOption = menu.getChosenOption();
            if (chosenOption == 1) {
                capitalsQuizGame(alreadySorted, menu);
            } else if (chosenOption == 2) {
                getCapitalForSpecificState(alreadyFilledMaps, alreadySorted);
            }
            // refreshing the counter
            correctAnswers = 0;
        }
        scanner.close();
    }

    private static void askCapitalQuestions(int numberOfQuestions) {
        for (int i = 0; i < numberOfQuestions; i++) {
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

    private static void capitalsQuizGame(boolean alreadySorted, Menu menu) {
        // We picked the option to answer capitals
        // showing the original contents of the array
        Printer.printArrayContents(stateCapitalArray);
        if (!alreadySorted) {
            // sorting the array
            BubbleSorter.sortByCapitals(stateCapitalArray);
        }
        // asking questions
        askCapitalQuestions(menu.getNumberOfQuestionsDesired());
        // revealing the score
        System.out.println("Thanks for playing, your score is: " + correctAnswers);
    }

    private static void getCapitalForSpecificState(boolean alreadyFilledMaps, boolean alreadySorted) {
        if (!alreadyFilledMaps) {
            if (!alreadySorted) {
                // sorting the array
                BubbleSorter.sortByCapitals(stateCapitalArray);
            }
            // filling the map and the tree map with the unsorted keys
            for (String[] stateCapitalPair : stateCapitalArray) {
                // the normal map
                stateCapitalMap.put(stateCapitalPair[0], stateCapitalPair[1]);
                // the sorted tree map
                stateCapitalTreeMap.put(stateCapitalPair[0], stateCapitalPair[1]);
            }
        }
        // displaying the contents of the normal map
        Printer.printMapContents(stateCapitalMap, "normal");
        // now we get the state name to search for its capital
        System.out.println("Please enter a state name to know the capital");
        String answer = Text.titleCase(scanner.nextLine());
        // next, we search in the tree map
        String stateCapital = stateCapitalTreeMap.get(answer);
        // if the provided state isn't in the map, print not found, else, print the
        // name of the capital
        System.out.println(stateCapital != null
                ? "The capital for the state of " + answer + " is " + stateCapital
                : "Sorry, the capital wasn't found, please try again");
    }
}