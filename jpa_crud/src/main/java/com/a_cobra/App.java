package com.a_cobra;

import java.util.List;
import java.util.Optional;

import com.a_cobra.controllers.UserController;
import com.a_cobra.models.User;

public class App {
    public static void main(String[] args) {
        UserController userController = new UserController();
        User user = new User(
                4L,
                "User4",
                "LastName4",
                "444444444",
                "user4@gmail.com",
                "myWeakPass4");

        // CREATE USER WORKS
        // userController.createUser(user);

        // UPDATE USER WORKS
        // without specifying an id WORKS
        // userController.updateUser(user);
        // with a valid id WORKS
        // userController.updateUser(user);

        // GETTING USERS WORKS
        // List<User> users = userController.getAllUsers();
        // for (User singleUser : users) {
        // System.out.println(singleUser);
        // }

        // GETTING A USER BY ID WORKS
        // Optional<User> optionalUser = userController.getUserById(4L);
        // if (optionalUser.isPresent()) {
        // System.out.println(optionalUser.get());
        // }

        // DELETE USERS
        userController.deleteUser(user);
    }
}
