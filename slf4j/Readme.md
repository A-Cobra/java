# Java 17 Garage Logging Project

This is a Java 17 project that demonstrates the use of logging to track events that take place in a car garage. The project uses the following technologies:

- SLF4J: A simple logging facade for Java that allows you to use different logging frameworks (such as Logback) without changing your code.
- Logback: A logging framework that provides powerful features for logging and log management.
- Java records: A new feature in Java 14 that allows you to define classes with concise syntax and built-in methods for common operations.
- Optional class: A class introduced in Java 8 that allows you to represent a value that may or may not be present.

## Project Structure

The project consists of three classes:

- `Main`: The main class that runs the program.
- `CarGarage`: A class that represents a car garage and provides methods for adding and moving cars.
- `Car`: A Java record that represents a car and contains the car's id, top speed, and color.

## Usage

To run the program, simply run the `Main` class. The program initializes a `CarGarage` object and adds some cars to it, then moves some of the cars around to simulate events that take place in a garage.

The `CarGarage` class provides two methods:

- `addCar(Car car)`: Adds a new car to the garage.
- `moveCar(int id)`: Moves a car with the specified id to a new location.

The `Car` class is a Java record that contains three fields:

- `id`: An integer representing the car's id.
- `topSpeed`: An integer representing the car's top speed in kilometers per hour.
- `color`: A string representing the car's color.

The program uses logging to track events that take place in the garage. The logging configuration is defined in the `logback.xml` file, which is located in the `src/main/resources` directory.

## Logging

The program uses SLF4J as a logging facade and Logback as the underlying logging implementation. The logging configuration is defined in the `logback.xml` file, which specifies the following:

- A console appender that logs messages to the console.
- A logger that logs messages at the `INFO` level or higher to both the console and the file appender.

The program uses logging to track the following events:

- Adding a new car to the garage.
- Moving a car to a new location.
- Trying to move a car that doesn't exist in the garage.

## Contributing

Contributions to this project are welcome. If you find a bug or want to suggest a new feature, please create an issue on GitHub. If you want to contribute code, please fork the project, create a new branch, and submit a pull request.

## License

This project is licensed under the [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0).

## Conclusion

This project demonstrates how to use logging to track events in a Java application using SLF4J and Logback. It also shows how to use Java records to define simple data classes with built-in methods for common operations, and how to use the Optional class to represent a value that may or may not be present.
