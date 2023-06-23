package com.a_cobra;

import com.a_cobra.controllers.UserController;
import com.a_cobra.models.User;

/**
 * Hello world!
 *
 */
public class App {
    private static final UserController userController = new UserController();

    public static void main(String[] args) {
        User createdUser = userController.createUser(
                "User4",
                "LastName4",
                "444444444",
                "user4@gmail.com",
                "myWeakPass3");
        System.out.println(createdUser.getName() == null ? "Not created user" : "User created successfully");
    }
}
