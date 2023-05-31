# US States and Capitals Learning Game

This Java console application is a fun and interactive way to learn the states and capitals of the USA. It is designed to help users to memorize the names of all 50 states and their corresponding capitals.

## Features

- Learn the names of the 50 states and their corresponding capitals
- Two modes of learning: by state and by capital
- Uses bubble sort algorithm to sort the states and capitals in alphabetical order by state name or capital name
- Utilizes HashMap and TreeMap data structures to store and retrieve state/capital data
- Practice using the Java Collections API

## Installation

1. Clone the repository to your local machine from `https://github.com/A-Cobra/java/tree/develop`
2. Ensure that you have Java 8 or higher installed on your machine
3. Open a terminal or command prompt and navigate to the project directory by entering the following command: `cd /path/to/project/directory/algorithms_and_data_structures/src`
4. Compile the Java source files using the following command:

```
javac *.java
```

5. Run the application using the following command:

```
java Main
```

## Usage

Upon launching the application, the user will be presented with a menu that allows them to choose between two ways of learning:

### Learn by State

In this mode, the user selects a number of states they want to learn, and the application will randomly select those states and ask the user to enter the corresponding capital. At the end of the quiz, the user will receive a score based on the number of correct answers.

### Learn by Capital

In this mode, the user can input a state name, and the application will return the corresponding capital. This mode is useful for practicing the capital names for specific states.

Note: To switch between the two learning modes, the user can simply restart the application and select the desired mode from the menu.

## Screenshots

<div>
  <img src ="algorithms_and_data_structures/images/menu.PNG">
  <p>Menu</p>
</div>

<div>
  <img src ="algorithms_and_data_structures/images/first_mode.PNG">
  <p>First Mode</p>
</div>

<div>
  <img src ="algorithms_and_data_structures/images/second_mode.PNG">
  <p>Second Mode</p>
</div>

## Implementation Details

The application stores the state/capital data as a HashMap inside the Main class. The state name is used as the key, and the capital name is used as the value. The data is sorted by either the state name or the capital name, depending on the user's choice in learning mode.

The application uses the Scanner class to read user input from the console, and the System.out.println() method to output messages to the console.

Note: The state/capital data is hardcoded into the Main class, rather than being read from a CSV file, due to the requirements of the assignment.

## Comments

Please note that there may be a lot of comments in the code, as this was part of the assignment for the Data Structures & Algorithms course from study.com. While these comments may make the code easier to understand, they may also make the code look cluttered. We have tried to keep the comments to a minimum while still providing explanations where necessary.

## Conclusion

The US States and Capitals Learning Game is a fun and interactive way to learn the names of all 50 states and their corresponding capitals. It utilizes the Java Collections API and implements basic algorithms and data structures to provide an effective learning experience. We hope that you enjoy using this application, and that it helps you to master the names of the US states and their capitals.
