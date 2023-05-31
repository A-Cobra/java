import java.util.Scanner;

public class Menu {
    private int option = 0;
    private Scanner scanner = new Scanner(System.in);

    public void show() {
        System.out.println();
        System.out.println();
        System.out.println("Welcome to the USA State Capital Game/App");
        System.out.println("Please select what you want to do");
        System.out.println("1. Practice by answering the capitals for certain states");
        System.out.println("2. Practice by getting the capital city for a specific state");
        System.out.println("-1. Leave the application");
        try {
            option = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Please enter only whole numbers");
            option = 0;
            scanner.nextLine();
            // this is done because there is a new character input that will keep executing
            // an the catch block would be called again and again
        }
    }

    public boolean isRunning() {
        return option != -1;
    }

    public int getChosenOption() {
        return option;
    }

    public int getNumberOfQuestionsDesired() {
        int numberOfQuestions = 50;
        System.out.println("Please select the number of states to answer their capitals");
        try {
            numberOfQuestions = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("The introduced input wasn't adequate");
        }
        if (numberOfQuestions > 50 || numberOfQuestions < 1) {
            // To ask the whole set of questions
            numberOfQuestions = 50;
        }
        return numberOfQuestions;
    }
}
