# JPA Tutorial Project

This is a sample Java project that demonstrates the usage of JPA (Java Persistence API) with several layers of architecture. The project includes a `JPAConnection` class that manages the connection to a MariaDB database, a `UserController` class that handles user-related operations, and an `App` class that serves as the entry point of the application.

## Technologies Used

The following technologies were used in this project:

- Maven: a build automation tool used to manage dependencies and build the project
- JPA: a Java specification for ORM (Object-Relational Mapping) that provides a way to map Java objects to relational database tables
- GitHub: a version control system used to manage the source code of the project
- Lombok: a Java library used to reduce boilerplate code in POJO (Plain Old Java Object) classes
- MariaDB: a popular open-source relational database management system
- Optional class: a Java class introduced in Java 8 that provides a way to handle null values in a more explicit and safer way

## Architecture

The project follows a layered architecture with the following components:

- `JPAConnection`: a class that manages the connection to the database using JPA
- `UserController`: a class that handles user-related operations, such as creating, updating, and retrieving users
- `App`: the entry point of the application that initializes the `JPAConnection` and `UserController` classes and runs the application

The layered architecture promotes separation of concerns and modularity, making the code easier to maintain and extend.

## Usage

To run the application, follow these steps:

1. Clone the project from GitHub: `git clone https://github.com/A-Cobra/java`
2. Navigate to the following folder: `jpa_crud`
3. Switch branches by using the following command: `git checkout develop`
4. Open the project in your IDE (Integrated Development Environment) of choice
5. Build the project using Maven: `mvn clean install`
6. Run the `App` class to start the application
7. Use the `UserController` methods to perform user-related operations

## Configuration

Before running the application, make sure that you have the following prerequisites installed:

- Java Development Kit (JDK) version 8 or later
- MariaDB server version 10.0 or later

You also need to configure the following settings in the `persistence.xml` file located in the `src/main/META-INF` folder:

- `javax.persistence.jdbc.url`: the URL of the MariaDB database (e.g., `jdbc:mariadb://localhost:3306/mydb`)
- `javax.persistence.jdbc.user`: the username to use when connecting to the database
- `javax.persistence.jdbc.password`: the password to use when connecting to the database

## Contributing

Contributions to this project are welcome. If you find a bug or want to suggest a new feature, please create an issue on GitHub. If you want to contribute code, please fork the project, create a new branch, and submit a pull request.

## License

This project is licensed under the [Apache License 2.0](../LICENSE).
