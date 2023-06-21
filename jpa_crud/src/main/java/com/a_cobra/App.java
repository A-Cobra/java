package com.a_cobra;

import java.util.List;

import com.a_cobra.controllers.UserController;
import com.a_cobra.models.User;

public class App {
    public static void main(String[] args) {
        UserController userController = new UserController();
        User user = new User(
                3L,
                "User3",
                "LastName3",
                "333333333",
                "user3@gmail.com",
                "myWeakPass3");

        // CREATE USER WORKS
        // userController.createUser(user);

        // UPDATE USER WORKS
        // without specifying an id WORKS
        // userController.updateUser(user);
        // with a valid id WORKS
        userController.updateUser(user);

        // GETTING USERS WORKS
        // List<User> users = userController.getAllUsers();
        // for (User singleUser : users) {
        // System.out.println(singleUser);
        // }
    }
}
